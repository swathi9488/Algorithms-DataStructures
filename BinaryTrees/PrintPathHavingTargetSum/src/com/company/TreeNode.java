package com.company;

/**
 * Created by swathi on 5/1/16.
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }

    public static TreeNode buildTreeFromArray(Integer[] inputArray, int i) {
        if (i >= inputArray.length) {
            return null;
        }

        if (inputArray[i] == null) {
            return null;
        }

        TreeNode current = new TreeNode(inputArray[i]);

        int left = 2*i + 1;
        current.left = buildTreeFromArray(inputArray, left);

        int right = 2*i + 2;
        current.right = buildTreeFromArray(inputArray, right);

        return current;
    }
}
