package com.company;

/**
 * Created by swathi on 4/17/16.
 */
public class Vertex {
    private String value;
    private VertexState state;

    public Vertex(String val) {
        this.value = val;
        this.state = VertexState.UNVISITED;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public VertexState getState() {
        return state;
    }

    public void setState(VertexState state) {
        this.state = state;
    }
}
