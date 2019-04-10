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
        System.out.print("Absolute path to your PNG file: ");
        String path = scanner.next();

        // Init writer
        writer.data = reader.run(path);
        writer.path = path;

        // Generate files
        writer.generateObj();
        writer.generateMtl();
    }
}
