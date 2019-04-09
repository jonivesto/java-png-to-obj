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
        }
    }

    // Write .obj file
    public void generateObj(){
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
                    // Create face
                    faces.add(new Face(i, j));
                    //System.out.println("rgba(" + data[i][j].getRed() + ", "
                    //                           + data[i][j].getGreen() + ", "
                    //                           + data[i][j].getBlue() + ", "
                    //                           + data[i][j].getAlpha() + ") pos("
                    //                           + i + ", " + j + ")");
                    System.out.print("X ");
                } else System.out.print("  ");
            } System.out.println();
        }

        printVertices();

        // Save
        writer.close();
        System.out.println("Result: " + filepath(".obj"));
    }

    // Print all generated faces
    private void printVertices() {
        for (Face face : faces) {
            System.out.println(face);
            for (Vertex vertex : face.vertices) {
                System.out.println("x: " + vertex.x + " y: " + vertex.y + " z: " + vertex.z);
            }
        }
    }

    // Write .mtl file
    public void generateMtl(){
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".mtl"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }

        assert writer != null;
        setHeaders(writer);

        //TODO

        // Save
        writer.close();
        System.out.println("Result: " + filepath(".mtl"));
    }

}
