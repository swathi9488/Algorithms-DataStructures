package com.company;

public class Main {

    /*
    You have two arrays of integers, where the integers do not repeat and the two arrays have no common integers.
    Let x be any integer in the first array, y any integer in the second. Find min(Abs(x-y)).
    That is, find the smallest difference between any of the integers in the two arrays.
    Assumptions: Assume both arrays are sorted in ascending order
    */

    public static void main(String[] args) {
	// write your code here
        int[] arr1 = new int[]{5, 9, 13};
        int[] arr2 = new int[]{3, 7, 11, 16};
        System.out.println(findMinDiffBetweenSortedArrays(arr1, arr2));
    }

    private static int findMinDiffBetweenSortedArrays(int[] arr1, int[] arr2) {
        int i = 0; int j = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i != arr1.length && j != arr2.length) {
            minDiff = Math.min(minDiff, Math.abs(arr1[i] - arr2[j]));

            if (minDiff == 0) {
                return minDiff;
            }

            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return minDiff;
    }
}
