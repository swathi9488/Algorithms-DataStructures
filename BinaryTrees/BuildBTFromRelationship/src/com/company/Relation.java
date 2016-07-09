package com.company;

/**
 * Created by swathi on 6/28/16.
 */
public class Relation {
    public Integer parent;
    public Integer child;
    public boolean isLeft;

    public Relation(Integer child, Integer parent, boolean isLeft) {
        this.parent = parent;
        this.child = child;
        this.isLeft = isLeft;
    }
}
