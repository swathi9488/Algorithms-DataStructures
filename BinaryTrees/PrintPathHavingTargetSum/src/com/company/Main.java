package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode minusFive = new TreeNode(-5);
        TreeNode six1 = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode zero = new TreeNode(0);
        TreeNode twelve = new TreeNode(12);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode seven1 = new TreeNode(7);
        TreeNode thirteen = new TreeNode(13);
        TreeNode three = new TreeNode(3);
        TreeNode two1 = new TreeNode(2);
        TreeNode three1 = new TreeNode(3);
        TreeNode one1 = new TreeNode(1);
        TreeNode six2 = new TreeNode(6);
        TreeNode minusOne = new TreeNode(-1);

        six.left = seven;
        six.right = minusFive;
        seven.left = six1;
        seven.right = five;
        minusFive.left = zero;
        minusFive.right = twelve;
        five.left = one;
        five.right = two;
        zero.right = seven1;
        twelve.right = thirteen;
        two.left = three;
        seven1.left = six2;
        three.left = two1;
        three.right = three1;
        two1.left = one1;
        six2.right = minusOne;

        System.out.println("---- CASE to Print All paths having target sum ----");
        findSumGeneric(six, 13, new ArrayList<>(), 0);
        System.out.println("----------------------------------------------------");
        System.out.println();

        System.out.println("---- CASE to Print All paths having target sum only root to Leaf ----");
        findSumRootToLeaf(six, 13, 0, new ArrayList<>(), 0);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();

        System.out.println("---- CASE to Print All paths having target sum from any node but should end at leaf ----");
        findSumFromAnyToLeaf(six, 13, new ArrayList<>(), 0);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("---- CASE to Print All paths having target sum from root to any (should start at root) ----");
        findSumFromRootToAny(six, 13, new ArrayList<>(), 0);
        System.out.println("------------------------------------------------------------------------------------------");

    }

    public static void findSumGeneric(TreeNode node, int target, List<TreeNode> path, int level) {
        if (node == null) {
            return;
        }

        path.add(node);

        int currentSum = 0;
        for (int i = level; i >= 0; i--) {
            currentSum += path.get(i).value;
            if (currentSum == target) {
                printPath(path, i, level);
            }
        }

        findSumGeneric(node.left, target, path, level + 1);
        findSumGeneric(node.right, target, path, level + 1);

        path.remove(level);
    }

    public static void findSumRootToLeaf(TreeNode node, int target, int currentSum, List<TreeNode> path, int level) {
        if (node == null) {
            return;
        }

        currentSum += node.value;
        path.add(node);
        if (node.left == null && node.right == null) {
            if (target == currentSum) {
              printPath(path, 0, level);
            }
        } else {
            findSumRootToLeaf(node.left, target, currentSum, path, level + 1);
            findSumRootToLeaf(node.right, target, currentSum, path, level + 1);
        }

        path.remove(level);
    }

    public static void findSumFromAnyToLeaf(TreeNode node, int target, List<TreeNode> path, int level) {
        if (node == null) {
            return;
        }

        path.add(node);
        if (node.left == null && node.right == null) {
            int currentSum = 0;
            for (int i = level; i >= 0; i--) {
                currentSum += path.get(i).value;
                if (currentSum == target) {
                    printPath(path, i, level);
                }
            }
        } else {
            findSumFromAnyToLeaf(node.left, target, path, level + 1);
            findSumFromAnyToLeaf(node.right, target, path, level + 1);
        }

        path.remove(level);
    }

    public static void findSumFromRootToAny(TreeNode node, int target, List<TreeNode> path, int level) {
        if (node == null) {
            return;
        }

        path.add(node);
        int currentSum = 0;
        for (int i = level; i >= 0; i--) {
            currentSum += path.get(i).value;
        }

        if (currentSum == target) {
            printPath(path, 0, level);
        }

        findSumFromRootToAny(node.left, target, path, level + 1);
        findSumFromRootToAny(node.right, target, path, level + 1);

        path.remove(level);
    }


    public static void printPath(List<TreeNode> path, int i, int j) {
        System.out.print("Path that has the target sum:");
        for (int k = i; k <= j; k++) {
            System.out.print(path.get(k).value + "\t");
        }

        System.out.println();
    }
}
