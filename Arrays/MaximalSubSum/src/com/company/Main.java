package com.company;

public class Main {

    public static void main(String[] args) {
	    maximalSubSum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});

    }

    static void maximalSubSum(int[] arr) {
        int start = -1;
        int end = -1;
        int lStart = -1;
        int lEnd = -1;
        int max = 0;
        int localMax = 0;

        for (int i = 0; i < arr.length; i++) {
            localMax += arr[i];
            if (localMax < 0) {
                localMax = 0;
                lStart = lEnd = -1;
            } else {
                if (lStart == -1 && lEnd == -1) {
                    lStart = lEnd = i;
                } else {
                    lEnd = i;
                }
            }

            if (localMax > max) {
                max = localMax;
                start = lStart;
                end = lEnd;
            }
        }

        System.out.println("Maximal Subsum:" + max);
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
