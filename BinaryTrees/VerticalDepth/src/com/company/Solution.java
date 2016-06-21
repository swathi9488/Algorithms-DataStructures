package com.company;

import java.util.*;

/**
 * Created by swathi on 6/7/16.
 */
public class Solution {
    public Map<Integer, List<TreeNode>> getVerticalColumnsBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, List<TreeNode>> resultMap = new TreeMap<>();
        if (root == null) {
            return resultMap;
        }

        root.depth = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            List<TreeNode> mapVal = resultMap.get(curr.depth);
            if (mapVal == null) {
                mapVal = new ArrayList<>();
            }

            mapVal.add(curr);
            resultMap.put(curr.depth, mapVal);
            if (curr.left != null) {
                curr.left.depth = curr.depth - 1;
                queue.add(curr.left);
            }

            if (curr.right != null) {
                curr.right.depth = curr.depth + 1;
                queue.add(curr.right);
            }
        }

        return resultMap;
    }

    public void printByVerticalPartition(TreeNode root) {
        Map<Integer, List<TreeNode>> resultMap = getVerticalColumnsBFS(root);
        for (Map.Entry<Integer, List<TreeNode>> entry : resultMap.entrySet()) {
            for (TreeNode node: entry.getValue()) {
                System.out.print(node.val + "\t");
            }
        }
    }

    public void buildVerticalDepthDFS(TreeNode root, int verticalDepth, int treeDepth,
                                      Map<Integer, Map<Integer, TreeNode>> resultMap ) {
        if (root == null) {
            return;
        }

        Map<Integer, TreeNode> innerMap = resultMap.get(verticalDepth);
        if (innerMap == null) {
           innerMap = new TreeMap<>();
        }
        innerMap.put(treeDepth, root);
        resultMap.put(verticalDepth, innerMap);
        buildVerticalDepthDFS(root.left, verticalDepth - 1, treeDepth + 1, resultMap);
        buildVerticalDepthDFS(root.right, verticalDepth + 1, treeDepth + 1, resultMap);
    }

    public void buildByVerticalDepthDFS(TreeNode root) {
        Map<Integer, Map<Integer, TreeNode>> resultMap = new TreeMap<>();
        buildVerticalDepthDFS(root, 0, 0, resultMap);
        for (Map.Entry<Integer, Map<Integer, TreeNode>> entry : resultMap.entrySet()) {
            for (Map.Entry<Integer, TreeNode> innerMap: entry.getValue().entrySet()) {
                System.out.print(innerMap.getValue().val + "\t");
            }
        }
    }
}
