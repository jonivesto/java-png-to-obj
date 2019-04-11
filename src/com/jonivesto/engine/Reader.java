package com.jonivesto.engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Reader {

    public Color[][] run(String path) {

        // Get image
        BufferedImage image = null;
        try { image = ImageIO.read(new File(path)); }
        catch (IOException e) { e.printStackTrace(); }

        // Get image dimensions
        assert image != null;
        int w = image.getWidth();
        int h = image.getHeight();

        // Check if image is legal size
        if(w > 255 || h > 255 || h < 1 || w < 1){
            System.err.println("Image resolution is too high. Width and height must be in range [1 - 255]");
            System.exit(0);
        }

        Color[][] pixels = new Color[w][h];

        // Get pixels
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                pixels[i][j] = new Color(image.getRGB(i, j), true);
            }
        }

        return pixels;
    }
}
