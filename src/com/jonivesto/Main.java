package com.jonivesto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Reader reader = new Reader();
        Writer writer = new Writer();

        // Get path
        //System.out.print("PNG file path: ");
        //String path = scanner.next();
        String path = "C:/Users/diabo/Desktop/test.png";

        // Init writer
        writer.data = reader.run(path);
        writer.path = path;

        // Generate
        writer.generateMtl();
        writer.generateObj();
    }
}
