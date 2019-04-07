package com.jonivesto;

import java.awt.*;
import java.io.File;

class Writer {

    void run(String path, Color[][] data){

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                System.out.print(" rgba(" + data[i][j].getRed() + ", " + data[i][j].getGreen() + ", " + data[i][j].getBlue() + ", " + data[i][j].getAlpha() + ")");
            }
            System.out.println();
        }

        // Files to be generated
        //System.out.println(filename(path) + ".obj");
        //System.out.println(filename(path) + ".mtl");

        //TODO: Write .obj

    }

    String filename(String path){
        return new File(path).getName().replaceFirst("[.][^.]+$", "");
    }
}
