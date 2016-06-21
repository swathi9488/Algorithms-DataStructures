package com.company;

/**
 * Created by swathi on 4/19/16.
 */
public class Edge {
    private Vertex v1;
    private Vertex v2;
    private int weight;
    private boolean presentInR;

    public Edge (Vertex v1, Vertex v2, int weight) {
        this.setV1(v1);
        this.setV2(v2);
        this.setWeight(weight);
        this.setPresentInR(false);
    }


    public Vertex getV1() {
        return v1;
    }

    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isPresentInR() {
        return presentInR;
    }

    public void setPresentInR(boolean presentInR) {
        this.presentInR = presentInR;
    }
}
