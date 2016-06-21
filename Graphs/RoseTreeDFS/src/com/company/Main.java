package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RoseTree root = new RoseTree(1);
        RoseTree two = new RoseTree(2);
        RoseTree three = new RoseTree(3);
        RoseTree four = new RoseTree(4);
        RoseTree five = new RoseTree(5);
        RoseTree six = new RoseTree(6);
        RoseTree seven = new RoseTree(7);
        RoseTree eight = new RoseTree(8);
        RoseTree nine = new RoseTree(9);
        RoseTree ten = new RoseTree(10);

        root.children.addAll(Arrays.asList(two, five));
        two.children.addAll(Arrays.asList(three, six, ten));
        three.children.addAll(Arrays.asList(four, seven, eight, nine));
        Solution solution = new Solution();

        System.out.println("DFS Iterative");
        solution.dfsIterative(root);
        System.out.println();

        System.out.println("DFS Recursive");
        solution.dfsRecursive(root);
        System.out.println();
    }
}
