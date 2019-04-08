package com.jonivesto;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

class Writer {

    // Member
    String path;
    Color[][] data;

    // Status
    String obj, mtl = "-";

    // Header comments for result files
    private final String[] HEADERS = {
            "This file is generated using .PNG to .OBJ converter",
            "Source: https://github.com/jonivesto/java-png-to-obj",
            "Author: Joni-Pekka Vesto",
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
    void generateObj(){
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".obj"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }

        assert writer != null;
        setHeaders(writer);

        // Get each pixel
        // Print preview
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                // Only process pixels with no transparency
                if(data[i][j].getAlpha() == 255){
                    //System.out.println("rgba(" + data[i][j].getRed() + ", "
                    //                           + data[i][j].getGreen() + ", "
                    //                           + data[i][j].getBlue() + ", "
                    //                           + data[i][j].getAlpha() + ") pos("
                    //                           + i + ", " + j + ")");
                    System.out.print("XX");
                } else System.out.print("  ");
            } System.out.println();
        }


        // Save
        writer.close();
        obj = "Result: " + filepath(".obj");
    }

    // Write .mtl file
    void generateMtl(){
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".mtl"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }

        assert writer != null;
        setHeaders(writer);

        //TODO: write material

        // Save
        writer.close();
        mtl = "Result: " + filepath(".mtl");
    }

}
