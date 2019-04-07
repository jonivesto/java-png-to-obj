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

        // Generate OBJ from the image file
        writer.data = reader.run(path);
        writer.path = path;
        writer.run();
    }
}
