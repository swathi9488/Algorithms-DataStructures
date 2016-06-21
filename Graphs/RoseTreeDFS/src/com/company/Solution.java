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
        root.visited = true;
        stack.push(root);

        while (!stack.isEmpty()) {
            RoseTree node = stack.peek();
            int i = 0;
            int n = node.children.size();
            if (n == 0) {
                stack.pop();
                System.out.print(node.value + "\t");
            } else {
                while (n > 0 && i < n && node.children.get(i).visited) {
                    i++;
                }

                if (i == n) {
                    stack.pop();
                    System.out.print(node.value + "\t");
                } else {
                    RoseTree child = node.children.get(i);
                    child.visited = true;
                    stack.push(child);
                }
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
