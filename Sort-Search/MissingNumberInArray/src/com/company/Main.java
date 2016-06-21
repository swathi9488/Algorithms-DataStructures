package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = new int[]{1,2,3,4};
        System.out.println(getMissingNumberInUnSortedArray(arr, 0, arr.length - 1));
    }

    public static int getMissingNumberInSortedArray(int[] arr, int lb, int ub) {

        if (lb <= ub) {
            int mid = (lb+ub)/2;
            if (arr[mid] != mid + 1) {
               if (mid == 0 || mid == arr.length - 1) {
                   return mid+1;
               } else if (arr[mid] - arr[mid - 1] == 1) {
                   return getMissingNumberInSortedArray(arr, lb, mid - 1);
               } else {
                   return mid + 1;
               }
            } else {
                return getMissingNumberInSortedArray(arr, mid+1, ub);
            }
        }

        return arr.length + 1;
    }

    public static int getMissingNumberInUnSortedArray(int[] arr, int lb, int ub) {

        int i = 0;
        int xor = 0;
        for (i = 0; i < arr.length; i++) {
            // i+1 will be "i" if missing number from (0  ... n) both inclusive in an n length
            // i+1 for missing number from (1 ... n+1) both inclusive in a n length array
            xor ^= (i+1) ^ arr[i];
        }

        return xor^(i+1);
    }
}
