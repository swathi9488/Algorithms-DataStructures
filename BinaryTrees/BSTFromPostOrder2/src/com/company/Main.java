package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        int[] postOrder = {1, 4, 3, 6, 8, 7, 5, 50, 40, 10};
        //Tree root = contructBST(Arrays.asList(postOrder));
        AtomicInteger postOrderIndex = new AtomicInteger(postOrder.length - 1);
        Tree optimizedRoot = constructBST(postOrder, postOrder[postOrder.length - 1], Integer.MIN_VALUE, Integer.MAX_VALUE, postOrderIndex);
        System.out.println(optimizedRoot.value);

    }

    // O(n^2) algorithm
    public static Tree contructBST(List<Integer> postOrder) {
        if (postOrder.size() == 1) {
            return new Tree(postOrder.get(0));
        }

        int rootVal = postOrder.get(postOrder.size() - 1);
        Tree root = new Tree(rootVal);

        int leftSubtreeIndex = calculatePartitionElement(postOrder, rootVal);

        // Left subttree
        if (leftSubtreeIndex == -1) {
            root.left = null;
        } else {
            int count = 0;
            List<Integer> leftSubTree = new ArrayList<>();
            while (count <= leftSubtreeIndex) {
                leftSubTree.add(postOrder.get(count++));
            }
            root.left = contructBST(leftSubTree);
        }

        // right subtree
        if (leftSubtreeIndex == postOrder.size() - 2) {
            root.right = null;
        } else {
            int count = leftSubtreeIndex+1;
            List<Integer> rightSubTree = new ArrayList<>();
            while (count != postOrder.size() - 1) {
                rightSubTree.add(postOrder.get(count++));
            }
            root.right = contructBST(rightSubTree);
        }

        return root;
    }

    static int calculatePartitionElement(List<Integer> arr, int largest) {
        int i;
        for (i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i) <= largest) {
                return i;
            }
        }
        return i;
    }

    public static Tree constructBST(int[] postOrder, int key, int min, int max, AtomicInteger postOrderIndex) {
        if (postOrderIndex.get() < 0) {
            return null;
        }

        Tree root = null;
        if (key > min && key < max) {
            root = new Tree(key);
            int currIdx = postOrderIndex.get();
            postOrderIndex.set(currIdx - 1);
            if (postOrderIndex.get() != -1) {
                root.right = constructBST(postOrder, postOrder[postOrderIndex.get()], key, max, postOrderIndex);
            }
            if (postOrderIndex.get() != -1) {
                root.left = constructBST(postOrder, postOrder[postOrderIndex.get()], min, key, postOrderIndex);
            }
        }

        return root;
    }
}
