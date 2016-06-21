package com.company;

/**
 * Created by swathi on 4/30/16.
 */
public class Tree {
    int value;
    Tree left;
    Tree right;

    public Tree (int val) {
        this.value = val;
        this.left = this.right = null;
    }
}
