package com.company;

import java.util.*;
/**
 * Created by swathi on 6/22/16.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Node, List<Node>> adj = new HashMap<>(numCourses);
        List<Node> nodes = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            Node newNode = new Node(i);
            nodes.add(newNode);
            adj.put(newNode, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            Node currNode = nodes.get(curr[1]);

            List<Node> adjNodes = adj.get(currNode);
            if (adjNodes == null) {
                adjNodes = new ArrayList<>();
            }

            Node n = nodes.get(curr[0]);
            adjNodes.add(n);
            adj.put(currNode, adjNodes);
        }

        Set<Integer> orderFirstFinished = new LinkedHashSet<>();
        for (Map.Entry<Node, List<Node>> entry : adj.entrySet()) {
            if (entry.getKey().state == 0 && !getTopological(entry.getKey(), adj, orderFirstFinished)) {
                orderFirstFinished = new LinkedHashSet<>();
                break;
            }
        }

        int lSize = orderFirstFinished.size();
        if (lSize == 0) {
            return new int[]{};
        }

        int[] result = new int[lSize];
        int i = lSize - 1;
        for (Integer item : orderFirstFinished) {
            result[i--] = item;
        }

        return result;
    }

    private boolean getTopological(Node node, Map<Node, List<Node>> adj, Set<Integer> orderFirstFinished) {
        if (node == null) {
            return true;
        }

        node.state = 1;
        for (Node child : adj.get(node)) {
            if (child.state == 0) {
                boolean childResult = getTopological(child, adj, orderFirstFinished);
                // DO NOT return the above line! thats incorrect.
                //you have to go through all children.
                //You wasted 2 hours trying to solve this issue!
                if (!childResult) {
                    return false;
                }
            } else if (child.state == 1) {
                return false;
            }
        }
        node.state = 2;
        adj.put(node, adj.get(node));
        orderFirstFinished.add(node.val);
        return true;
    }

    class Node {
        int val;
        int state;
        public Node(int val) {
            this.val = val;
            this.state = 0;
        }

        @Override
        public int hashCode() {
            return val;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Node) && (this.val == ((Node) o).val);
        }
    }
}