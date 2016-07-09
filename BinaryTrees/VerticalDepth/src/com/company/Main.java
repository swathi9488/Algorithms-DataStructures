package com.company;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        //TreeNode root = new Codec().deserialize("1,2,4,X,X,5,X,X,3,6,X,X,7,X,X");
        TreeNode root = new Codec().deserialize("3,9,4,X,X,0,X,X,8,1,5,X,X,2,X,X,7,X,X");

        Solution solution = new Solution();
        solution.printByVerticalPartition(root);
        System.out.println();
        solution.buildByVerticalDepthDFS(root);

    }
}
