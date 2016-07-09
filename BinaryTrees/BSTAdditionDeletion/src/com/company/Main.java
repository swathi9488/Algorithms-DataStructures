package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = addToBST(null, new TreeNode(19));
        root = addToBST(root, new TreeNode(10));
        root = addToBST(root, new TreeNode(27));
        root = addToBST(root, new TreeNode(34));
        root = addToBST(root, new TreeNode(20));
        root = addToBST(root, new TreeNode(15));
        root = addToBST(root, new TreeNode(6));
        root = addToBST(root, new TreeNode(4));
        root = addToBST(root, new TreeNode(5));
        root = addToBST(root, new TreeNode(7));

        //root = deleteFromBST(root, root.left.left);
        //root = deleteFromBST(root, root.left.left);
        //root = deleteFromBST(root, root.left.left);

        root = deleteNode(root, root.left.right);
        root = deleteNode(root, root.left);
        System.out.println(root);
    }

    public static TreeNode addToBST(TreeNode root, TreeNode target) {
        if (root == null) {
            return target;
        }
        
        if (target == null) {
            return root;
        }
        
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.val > target.val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }

        if (prev.val > target.val) {
            prev.left = target;
        } else {
            prev.right = target;
        }

        return root;
    }

    public static TreeNode deleteFromBST(TreeNode root, TreeNode deleteNode) {
        if (root == null || deleteNode == null) {
            return root;
        }

        TreeNode prev = null;
        TreeNode curr = root;

        while (curr != null && curr != deleteNode) {
            if (curr.val > deleteNode.val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }

        if (curr == null) {
            return root;
        }

        if (prev == null) {
            root = addToBST(curr.left, curr.right);
            curr.left = curr.right = null;
            return root;
        }

        if (prev.val > curr.val) {
            prev.left = addToBST(curr.left, curr.right);
        } else {
            prev.right = addToBST(curr.left, curr.right);
        }

        curr.left = curr.right = null;
        return root;
    }

    public static TreeNode deleteNode(TreeNode root, TreeNode deleteNode) {
        if (root == null || deleteNode == null) {
            return root;
        }

        if (root.val > deleteNode.val) {
            root.left = deleteNode(root.left, deleteNode);
        } else if (root.val < deleteNode.val) {
            root.right = deleteNode(root.right, deleteNode);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Inorder Successor
            TreeNode inOderSuccessor = getLeftMostNode(root.right);
            root.val = inOderSuccessor.val;
            root.right = deleteNode(root.right, inOderSuccessor);
        }

        return root;
    }

    public  static TreeNode getLeftMostNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root;
        }

        return getLeftMostNode(root.left);

    }
}
