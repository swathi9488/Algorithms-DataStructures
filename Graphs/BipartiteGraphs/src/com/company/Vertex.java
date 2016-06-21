package com.company;

/**
 * Created by swathi on 5/22/16.
 */
public class Vertex {
    char value;
    VertexState state;

    public Vertex(char c) {
        this.value = c;
        state = VertexState.UNIVISTED;
    }
}
