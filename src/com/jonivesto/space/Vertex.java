package com.jonivesto.space;

public class Vertex {

    private double x, y, z;

    Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Line to be written in obj file
    public String getMarkup(){
        return "v " + x + " " + y + " " + z;
    }

}
