package com.jonivesto.engine;

import com.jonivesto.space.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Writer {

    public String path;
    public Color[][] data;

    private ArrayList<Face> faces = new ArrayList<>();
    private ArrayList<Material> materials = new ArrayList<>();

    private ArrayList<String> usedVertices = new ArrayList<>();

    // Header comments for result files
    private final static String[] HEADERS = {
            "This file is generated using .PNG to .OBJ converter",
            "Source: https://github.com/jonivesto/java-png-to-obj",
            "Website: https://www.jonivesto.com"
    };

    // Generates path for a new file
    private String filepath(String extension){
        return new File(path).getParent() + "/" + filename() + extension;
    }

    // Get file name without extension
    private String filename(){
        return new File(path).getName().replaceFirst("[.][^.]+$", "");
    }

    // File header comments
    private void setHeaders(PrintWriter writer) {
        for (String line : HEADERS) {
            writer.println("# " + line);
        } writer.println("");
    }

    // Print all generated faces
    private void printVertices() {
        for (Face face : faces) {
            System.out.println(face);
            for (Vertex vertex : face.vertices) {
                System.out.println(vertex.getMarkup());
            }
        }
    }

    // Print all generated materials
    private void printMaterials() {
        for (Material material : materials) {
            System.out.println("Material: " + material.name);
        }
    }

    // Write .obj file
    public void generateObj(){
        // Prepare writer
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".obj"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }
        assert writer != null;
        setHeaders(writer);

        // Get each pixel
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {

                // Only process pixels with no transparency
                if(data[i][j].getAlpha() == 255){

                    // Make material from pixel color
                    Material material = null;
                    boolean duplicate = false;

                    // Check if material exists
                    for (Material m : materials) {
                        if(m.name.equals(materialName(data[i][j]))){
                            material = m;
                            duplicate = true;
                        }
                    }

                    // Create material if not exists
                    if(!duplicate){
                        Material newMaterial = new Material(materialName(data[i][j]), data[i][j]);
                        materials.add(newMaterial);
                        material = newMaterial;
                    }

                    // Create faces
                    faces.add(new Face(i, j, 0.0, material));

                    // Print preview
                    System.out.print("10");
                } else System.out.print("  ");
            } System.out.println();
        }

        // Declare material file
        writer.println("mtllib " + filename() + ".mtl");
        printMaterials();

        // Write vertices
        for (Face face : faces) {
            for (Vertex vertex : face.vertices) {
                // Add and write vertive if not already written
                String markup = vertex.getMarkup();
                if(!usedVertices.contains(markup)){
                    usedVertices.add(markup);
                    writer.println(markup);
                } else {
                    //TODO: Get indexOf
                }
            }
        }

        // Save and close
        writer.close();
        System.out.println("File: " + filepath(".obj"));
    }

    // Write .mtl file
    public void generateMtl(){
        // Prepare writer
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".mtl"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }
        assert writer != null;
        setHeaders(writer);

        // Define and write materials
        for (Material material : materials) {
            writer.println("newmtl " + material.name); // Declare
            writer.println("illum 1"); // Illumination
            writer.println("Kd " + material.getDiffuse()); // Diffuse
            writer.println("Ka 0.00 0.00 0.00"); // Ambient
            writer.println("Ks 0.00 0.00 0.00"); // Specular
            writer.println("Tf 1.00 1.00 1.00");
            writer.println(""); // Space
        }

        // Save and close
        writer.close();
        System.out.println("File: " + filepath(".mtl"));
    }

    // Create material name from Color object
    private String materialName(Color color) {
        String r = Integer.toHexString(color.getRed());
        String g = Integer.toHexString(color.getGreen());
        String b = Integer.toHexString(color.getBlue());

        return "mat_" + (r.length() == 1? "0" + r : r) +
                        (g.length() == 1? "0" + g : g) +
                        (b.length() == 1? "0" + b : b);
    }

}
