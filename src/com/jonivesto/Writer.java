package com.jonivesto;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

class Writer {

    String path;
    Color[][] data;

    void run(){
        printInput();
        generateObj();
        generateMtl();
    }

    // Print input data
    private void printInput(){
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                System.out.print(" rgba(" + data[i][j].getRed() + ", " + data[i][j].getGreen() + ", " + data[i][j].getBlue() + ", " + data[i][j].getAlpha() + ")");
            }
            System.out.println();
        }System.out.println();
    }

    // Write .obj file
    private void generateObj(){
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".obj"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }
        assert writer != null;

        // File header comments
        writer.println("# THIS 3D MODEL IS GENERATED FROM A PNG IMAGE");
        writer.println("# https://github.com/jonivesto/java-png-to-obj");

        //TODO

        writer.close();
    }

    // Write .mtl file
    private void generateMtl(){
        PrintWriter writer = null;
        try { writer = new PrintWriter( filepath(".mtl"), "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }
        assert writer != null;

        // File header comments
        writer.println("# https://github.com/jonivesto/java-png-to-obj");

        //TODO

        writer.close();
    }

    // Generates path for a new file
    String filepath(String extension){
        return new File(path).getParent() + "/" + filename() + extension;
    }

    // Get file name without extension
    String filename(){
        return new File(path).getName().replaceFirst("[.][^.]+$", "");
    }
}
