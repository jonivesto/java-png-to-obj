package com.jonivesto;

import com.jonivesto.engine.Reader;
import com.jonivesto.engine.Writer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Reader reader = new Reader();
        Writer writer = new Writer();

        // Get path
        //System.out.print("Absolute path to your PNG file: ");
        //String path = scanner.next();
        String path = "C:/Users/diabo/Desktop/test.png";

        // Init writer
        writer.data = reader.run(path);
        writer.path = path;

        // Generate files
        writer.generateMtl();
        writer.generateObj();

        // Print result paths
        System.out.println(writer.obj);
        System.out.println(writer.mtl);
    }
}
