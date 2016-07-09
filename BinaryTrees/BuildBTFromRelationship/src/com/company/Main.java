package com.company;

import java.util.*;

//https://www.careercup.com/question?id=5668114807128064
public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Relation> relations = new ArrayList<>();
        relations.add(new Relation(15,20,true));
        relations.add(new Relation(19,80,true));
        relations.add(new Relation(17,20,false));
        relations.add(new Relation(16,80,false));
        relations.add(new Relation(80,50,false));
        relations.add(new Relation(50,null,false));
        relations.add(new Relation(20,50,true));
        TreeNode treeNode = buildTree(relations);
        preOrder(treeNode);
    }

    private static TreeNode buildTree(List<Relation> relations) {
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = null;
        for (int i = 0; i < relations.size(); i++) {
            TreeNode child = map.get(relations.get(i).child);

            if (child == null) {
                child = new TreeNode(relations.get(i).child);
                map.put(relations.get(i).child, child);
            }

            if (relations.get(i).parent != null) {
                TreeNode currRoot = map.get(relations.get(i).parent);
                if (currRoot == null) {
                    currRoot = new TreeNode(relations.get(i).parent);
                    map.put(relations.get(i).parent, currRoot);
                }

                if (relations.get(i).isLeft) {
                    currRoot.left = child;
                } else {
                    currRoot.right = child;
                }

            } else {
                root = child;
            }

        }
        return root;
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }
}
