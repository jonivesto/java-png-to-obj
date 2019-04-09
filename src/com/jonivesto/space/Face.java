package com.jonivesto.space;

public class Face {

    private final static double H = 0.5;

    public Vertex[] vertices = new Vertex[4];

    // Construct from pixels
    public Face(double x, double y){
        vertices[0] = new Vertex(x - H, y - H, 0);
        vertices[1] = new Vertex(x + H, y - H, 0);
        vertices[2] = new Vertex(x - H, y + H, 0);
        vertices[3] = new Vertex(x + H, y + H, 0);
    }

    // Construct from vertices
    public Face(Vertex[] vertices){
        assert vertices.length != 4;
        this.vertices = vertices;
    }

}
