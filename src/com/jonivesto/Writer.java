package com.jonivesto;

import java.awt.*;
import java.io.File;

class Writer {

    void run(String path, Color[][] data){

        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }

    }

    String filename(String path){
        return new File(path).getName();
    }
}
