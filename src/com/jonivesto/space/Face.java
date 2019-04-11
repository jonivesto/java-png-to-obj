package com.jonivesto.space;

public class Face {

    private final static double H = 0.5;

    public Vertex[] vertices = new Vertex[4];
    public Material material;

    // Construct from pixels
    public Face(double x, double y, double z, Material material){
        vertices[0] = new Vertex(x - H, y - H, z);
        vertices[1] = new Vertex(x + H, y - H, z);
        vertices[2] = new Vertex(x - H, y + H, z);
        vertices[3] = new Vertex(x + H, y + H, z);
        this.material = material;
    }

    // Line to be written in obj file
    public String getMarkup() {
        return "f " + vertices[1].id + " " + vertices[0].id + " " + vertices[2].id + " " + vertices[3].id;
    }
}
