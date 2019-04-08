package com.jonivesto;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

class Writer {

    // Members
    String path;
    Color[][] data;

    // Results
    String obj = "-";
    String mtl = "-";

    // Generates path for a new file
    private String filepath(String extension){
        return new File(path).getParent() + "/" + filename() + extension;
    }

    // Get file name without extension
    private String filename(){
        return new File(path).getName().replaceFirst("[.][^.]+$", "");
    }

    // Write .obj file
    void generateObj(){
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".obj"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }
        assert writer != null;

        // File header comments
        writer.println("# THIS 3D MODEL IS GENERATED FROM A PNG IMAGE");
        writer.println("# https://github.com/jonivesto/java-png-to-obj");

        // Get each pixel
        // Print preview
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                // Only process pixels with no transparency
                if(data[i][j].getAlpha() == 255){
                    /*System.out.println("rgba(" + data[i][j].getRed() + ", "
                                               + data[i][j].getGreen() + ", "
                                               + data[i][j].getBlue() + ", "
                                               + data[i][j].getAlpha() + ") pos("
                                               + i + ", " + j + ")");*/
                    System.out.print("XX");
                } else System.out.print("  ");
            } System.out.println();
        }

        // Convert to vertices
        data = toVertices();

        // Save
        writer.close();
        obj = "Result: " + filepath(".obj");
    }

    // Expand pixel array to vertice array
    private Color[][] toVertices() {

        Color[][] verts = null;



        return verts;
    }

    // Write .mtl file
    void generateMtl(){
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".mtl"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }
        assert writer != null;

        // File header comments
        writer.println("# https://github.com/jonivesto/java-png-to-obj");

        //TODO: write material

        // Save
        writer.close();
        mtl = "Result: " + filepath(".mtl");
    }

}
