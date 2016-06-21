package com.company;

/**
 * Created by swathi on 3/12/16.
 */
public class Tree {
    Tree left;
    Tree right;
    int value;

    public Tree(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }
}
