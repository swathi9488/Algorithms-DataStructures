package com.company;

/**
 * Created by swathi on 5/2/16.
 */
public class LinkNode {
    int value;
    LinkNode next;
    int carry;

    public LinkNode(int val) {
        this.value = val;
        this.next = null;
        this.carry = 0;
    }

    public LinkNode(int val, int carry) {
        this.value = val;
        this.next = null;
        this.carry = carry;
    }
}
