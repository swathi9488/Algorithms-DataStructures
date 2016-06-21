package com.company;

/**
 * Created by swathi on 4/30/16.
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int val) {
        this.value = val;
        this.left = this.right = null;
    }
}
