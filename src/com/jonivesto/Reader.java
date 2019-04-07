package com.jonivesto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Reader {

    Color[][] run(String path) {

        // Get image
        BufferedImage image = null;
        try { image = ImageIO.read(new File(path)); }
        catch (IOException e) { e.printStackTrace(); }

        // Get image dimensions
        int w = image.getWidth();
        int h = image.getHeight();

        Color[][] pixels = new Color[w][h];

        // Get pixels
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                Color color = new Color(image.getRGB(i, j), true);
                pixels[i][j] = color;
                System.out.println("rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + color.getAlpha() + ")");
            }
        }

        return pixels;
    }
}
