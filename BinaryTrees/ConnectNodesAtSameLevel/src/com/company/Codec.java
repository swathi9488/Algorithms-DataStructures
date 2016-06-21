package com.company;

import java.util.*;

/**
 * Created by swathi on 5/19/16.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        String result = String.valueOf(root.val);
        while (!current.isEmpty()) {
            List<TreeNode> parents = current;
            int parentLength = parents.size();
            current = new ArrayList<>();
            int i = 0;
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                    result += "," + parent.left.val;
                } else {
                    // conditions for putting a null for a null child:
                    //1. right sibling is not null
                    //2. next element in the parent list has alteast one child
                    //3. the future current list (children) list is not null
                    if (
                            parents.get(i).right != null ||
                                    (i != (parentLength - 1) && (parents.get(i+1).left != null || parents.get(i+1).right != null) ||
                                            !current.isEmpty())
                            ) {
                        result += ",null";
                    }
                }

                // conditions for putting a null for a null child:
                //1. left sibling is not null
                //2. next element in the parent list has alteast one child
                //3. the future current list (children) list is not null
                if (parent.right != null) {
                    current.add(parent.right);
                    result += "," + parent.right.val;
                } else {
                    if (parents.get(i).left != null ||
                            (i != (parentLength - 1) && (parents.get(i+1).left != null || parents.get(i+1).right != null)) ||
                            !current.isEmpty()) {
                        result += ",null";
                    }
                }
                i++;
            }
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] treeElements = data.split(",");
        List<TreeNode> current = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(treeElements[0]));
        current.add(root);

        int i = 0;
        while (!current.isEmpty()) {
            List<TreeNode> parents = current;
            current = new ArrayList<>();
            for (TreeNode parent : parents) {
                if (parent != null) {
                    if (2*i+1 < treeElements.length && !treeElements[2*i+1].equals("null")) {
                        parent.left = new TreeNode(Integer.parseInt(treeElements[2*i+1]));
                    } else {
                        parent.left = null;
                    }
                    current.add(parent.left);

                    if (2*i+2 < treeElements.length && !treeElements[2*i+2].equals("null")) {
                        parent.right = new TreeNode(Integer.parseInt(treeElements[2*i+2]));
                    } else {
                        parent.right = null;
                    }
                    current.add(parent.right);
                    i++;
                }
            }
        }
        return root;

    }
}
