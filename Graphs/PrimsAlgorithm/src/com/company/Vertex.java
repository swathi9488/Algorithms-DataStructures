package com.company;

/**
 * Created by swathi on 4/19/16.
 */
public class Vertex {
    private String value;
    private boolean presentInR;

    public Vertex(String val) {
        this.value = val;
        this.setPresentInR(false);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPresentInR() {
        return presentInR;
    }

    public void setPresentInR(boolean presentInR) {
        this.presentInR = presentInR;
    }

}
