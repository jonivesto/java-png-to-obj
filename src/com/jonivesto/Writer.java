package com.jonivesto;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

class Writer {

    void run(String path, Color[][] data){

        // Print read data
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                System.out.print(" rgba(" + data[i][j].getRed() + ", " + data[i][j].getGreen() + ", " + data[i][j].getBlue() + ", " + data[i][j].getAlpha() + ")");
            }
            System.out.println();
        }

        // Write file
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(path, ".obj"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }
        assert writer != null;

        // File header comments
        writer.println("# THIS 3D MODEL IS GENERATED FROM A PNG IMAGE");
        writer.println("# https://github.com/jonivesto/java-png-to-obj");
        writer.close();

    }

    // Generates path for a new file
    String filepath(String path, String extension){
        return new File(path).getParent() + "/" +filename(path) + extension;
    }

    // Get file name without extension
    String filename(String path){
        return new File(path).getName().replaceFirst("[.][^.]+$", "");
    }
}
