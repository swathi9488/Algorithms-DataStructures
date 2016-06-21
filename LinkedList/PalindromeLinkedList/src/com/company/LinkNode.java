package com.company;

/**
 * Created by swathi on 5/3/16.
 */
public class LinkNode {
    int value;
    LinkNode next;

    public LinkNode (int val) {
        this.value = val;
    }

    public int getLength() {
        LinkNode n = this;
        int count = 0;
        while (n != null) {
            n = n.next;
            count++;
        }

        return count;
    }
}
