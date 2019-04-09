package com.jonivesto.space;

public class Face {

    final double H = 0.5;

    private Vertex[] vertices = new Vertex[4];

    public Face(double x, double y){
        vertices[0] = new Vertex(x - H, y - H, 0);
        vertices[1] = new Vertex(x + H, y - H, 0);
        vertices[2] = new Vertex(x - H, y + H, 0);
        vertices[3] = new Vertex(x + H, y + H, 0);
    }

    // Get array of vertices
    public Vertex[] getVertices(){
        return this.vertices;
    }

}
