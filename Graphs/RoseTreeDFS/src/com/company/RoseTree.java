package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swathi on 5/22/16.
 */
public class RoseTree {
    int value;
    List<RoseTree> children;
    int childIdx;

    public RoseTree(int val) {
        this.value = val;
        children = new ArrayList<>();
        childIdx = -1;
    }
}
