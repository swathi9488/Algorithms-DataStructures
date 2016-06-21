package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Node six = new Node(6);
        Node four = new Node(4);
        Node ten = new Node(10);
        Node three = new Node(3);
        Node five = new Node(5);
        Node one = new Node(1);
        Node two = new Node(2);
        Node eight = new Node(8);
        Node fifteen = new Node(15);
        Node eleven = new Node(11);
        Node twenty = new Node(20);

        six.left = four;
        six.right = ten;

        four.left = three;
        four.right = five;

        three.left = one;
        three.right = two;

        ten.left = eight;
        ten.right = fifteen;

        fifteen.left = eleven;
        fifteen.right = twenty;

        //Node ancestor = findCommonAncestor(six, eleven, twenty);
        Node ancestor = findCommonAncestor(six, fifteen, eight);

        if (ancestor != null) {
            System.out.print(ancestor.value);
        } else {
            System.out.print("One of the nodes not present in the tree");
        }


    }

    private static boolean findPath (Node root, Node target, List<Node> path, int level) {
        if (root == null) {
            return false;
        }

        if (root == target) {
            path.add(target);
            return true;
        }

        path.add(root);

        // need to return without continuing hte recursion
        if (findPath(root.left, target, path, level + 1)) {
            return true;
        }

        // need to return without continuing hte recursion
        if (findPath(root.right, target, path, level + 1)) {
            return true;
        }

        // coz path is not immutable and has been altered in the recursive call
        path.remove(level);

        // finally get out of the recursive call saying the node is not present in this subtree
        return false;
    }

    public static Node findCommonAncestor(Node root, Node p, Node q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        if (p == q) {
            return p;
        }

        List<Node> pathP = new ArrayList<>();
        List<Node> pathQ = new ArrayList<>();

        boolean foundP = findPath(root, p, pathP, 0);
        boolean foundQ = findPath(root, q, pathQ, 0);

        int pathPSize = pathP.size();
        int pathQSize = pathQ.size();

        if (!foundP || !foundQ) {
            return null;
        }

        int i = 0;
        int j = 0;
        while (i != pathPSize && j != pathQSize &&
            pathP.get(i) == pathQ.get(j)) {
            i++;
            j++;
        }

        return pathP.get(i - 1);
    }
}
