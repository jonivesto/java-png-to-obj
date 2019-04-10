package com.jonivesto.space;

import java.awt.*;

public class Material {

    public String name;
    private Color color;

    public Material(String name, Color color){
        this.color = color;
        this.name = name;
    }

    // Normalize values in range 0-255 to range 0.0-1.0
    // Return string to be written in .mtl file
    public String getDiffuse(){
        return roundTwoPlaces((double)color.getRed()/255) + " "
             + roundTwoPlaces((double)color.getGreen()/255) + " "
             + roundTwoPlaces((double)color.getBlue()/255);
    }

    // Custom round method
    private static double roundTwoPlaces(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }
}
