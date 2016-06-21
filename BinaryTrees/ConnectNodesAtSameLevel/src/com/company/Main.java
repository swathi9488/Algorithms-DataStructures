package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("1,2,3,4,5,7,8,null,null,6,null,null,null,9,10");
        connectNodesAtSameLevel(root);
        System.out.println("Done");
    }

    public static void connectNodesAtSameLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            List<TreeNode> parent = current;
            current = new ArrayList<>();
            int i = 0;
            int parentSize = parent.size();
            while (i != parentSize) {
                TreeNode currNode = parent.get(i);
                if (i != parentSize - 1) {
                    currNode.next = parent.get(i+1);
                }

                if (currNode.left != null) {
                    current.add(currNode.left);
                }

                if (currNode.right != null) {
                   current.add(currNode.right);
                }
                i++;
            }
        }
    }
}
