package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {40, 60, 5, 1, 10, 80, 70, -1};
        int[] result = mergeSort(input, 0, input.length-1);
        System.out.print(result);
    }

    public static int[] mergeSort(int[] arr, int lb, int ub) {
        if (ub < lb) {
            return new int[]{};
        }
        if (ub == lb) {
            return new int[]{arr[lb]};
        } else {
            int n = ub - lb + 1;
            int[] left = mergeSort(arr, lb, lb+n/2-1);
            int[] right = mergeSort(arr, lb+n/2, ub);
            return merge(left, right);
        }
    }

    private static int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] result = new int[leftLength+rightLength];
        int count = 0;
        int i = 0;
        int j = 0;
        while (i != leftLength && j != rightLength) {
            if (left[i] <= right[j]) {
                result[count++] = left[i++];
            } else {
                result[count++] = right[j++];
            }
        }

        while(i != leftLength) {
            result[count++] = left[i++];
        }

        while(j != rightLength) {
            result[count++] = right[j++];
        }

        return result;
    }
}
