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

        // Raw array
        int[] rawPixels = image.getRGB(0, 0, w, h, null, 0, w);

        // Pretty array
        Color[][] pixels = new Color[w][h];

        for(int i = 0; i < h*w; i++) {
            // Pixel color
            Color color = new Color(rawPixels[i], true);
            System.out.println("rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + color.getAlpha() + ")");
            //TODO: Continue here
        }

        return pixels;
    }
}
