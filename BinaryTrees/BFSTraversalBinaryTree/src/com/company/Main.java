package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tree root = new Tree(1);
        Tree one = new Tree(2);
        Tree two = new Tree(3);
        Tree three = new Tree(4);
        Tree four = new Tree(5);
        Tree five = new Tree(6);

        root.left = one;
        root.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        //BFSTraversal(root);
        List<LinkedList<Tree>> resultList = getLevelLinkedList(root);

        // Solution in Cracking the coding interview
        //List<LinkedList<Tree>> resultList = getLevelLinkedListCTCI(root);

        int level = 0;
        for (List<Tree> levelLinkedList : resultList) {
            System.out.print("Nodes at level " + level + ":");
            for (Tree node : levelLinkedList) {
                System.out.print(node.value + "\t");
            }
            System.out.println();
            level++;
        }
    }

    private static void BFSTraversal(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int nodesAtLevel = queue.size();
            System.out.print("Nodes at Level " + level + ":");
            while (nodesAtLevel != 0) {
                Tree current = queue.remove();
                System.out.print(current.value + "\t");
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
                nodesAtLevel--;
            }
            System.out.println();
            level++;
        }
    }

    private static List<LinkedList<Tree>> getLevelLinkedList(Tree root) {
        if (root == null) {
           return null;
        }

        List<LinkedList<Tree>> resultList = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesAtLevel = queue.size();
            LinkedList<Tree> levelLinkedList = new LinkedList<>();
            while (nodesAtLevel != 0) {
                Tree current = queue.remove();
                levelLinkedList.add(current);
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
                nodesAtLevel--;
            }
            resultList.add(levelLinkedList);
        }

        return resultList;
    }

    // this is simpler that your way and doesnt require queue
    private static List<LinkedList<Tree>> getLevelLinkedListCTCI(Tree root) {
        if (root == null) {
            return null;
        }

        List<LinkedList<Tree>> resultList = new ArrayList<>();
        LinkedList<Tree> current = new LinkedList<>();
        current.add(root);

        while (!current.isEmpty()) {
            resultList.add(current);
            LinkedList<Tree> parents = current;
            current = new LinkedList<>();
            for (Tree parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }

                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        Integer[] nums = new Integer[3];
        List<Integer> list = new ArrayList<>(Arrays.asList(nums));
        return resultList;

    }
}
