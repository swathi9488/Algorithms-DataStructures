package com.company;

import java.util.*;

/**
 * Created by swathi on 5/22/16.
 */
public class Solution {
    public void dfsIterative(RoseTree root) {
        if (root == null) {
            return;
        }

        Stack<RoseTree> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            RoseTree node = stack.peek();
            if ((node.childIdx + 1) == node.children.size()) {
                stack.pop();
                System.out.print(node.value + "\t");
            } else {
                RoseTree child = node.children.get(node.childIdx + 1);
                node.childIdx += 1;
                stack.push(child);
            }
        }
    }

    public void dfsRecursive(RoseTree root) {
        if (root == null) {
            return;
        }

        if (root.children.size() == 0) {
            System.out.print(root.value + "\t");
            return;
        }

        for (RoseTree child : root.children) {
            dfsRecursive(child);
        }

        System.out.print(root.value + "\t");
    }
}
