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
                pixels[i][j] = new Color(image.getRGB(i, j), true);
            }
        }

        return pixels;
    }
}
