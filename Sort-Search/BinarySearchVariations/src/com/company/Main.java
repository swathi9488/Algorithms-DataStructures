package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = new int[] {1, 2, 3, 7 ,9, 10};
        int i = binarySearchLargerThanTarget(input, 0, 0, input.length -1);
        if (i == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println(input[i]);
        }

        int[] input1 = new int[] {1, 2, 3, 7 ,9, 10};
        int i1 = binarySearchMinimumLargestThanTarget(input1, 0, 0, input.length -1,Integer.MAX_VALUE, -1);
        if (i1 == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println(input[i1]);
        }
    }

    public static int binarySearch(int[] arr, int target, int lb, int ub) {

        if (lb <= ub) {
            int mid = (lb+ub)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, ub);
            } else {
                return binarySearch(arr, target, lb, mid - 1);
            }
        }

        return -1;
    }

    public static int binarySearchLargerThanTarget(int[] arr, int target, int lb, int ub) {

        if (lb <= ub) {
            int mid = (lb+ub)/2;
            if (arr[mid] > target) {
                return mid;
            } else {
                return binarySearchLargerThanTarget(arr, target, mid+1, ub);
            }
        } else {
            return -1;
        }
    }

    public static int binarySearchSmallerThanTarget(int[] arr, int target, int lb, int ub) {

        if (lb <= ub) {
            int mid = (lb+ub)/2;
            if (arr[mid] < target) {
                return mid;
            } else  {
                return binarySearchSmallerThanTarget(arr, target, lb, mid-1);
            }
        } else {
            return -1;
        }
    }

    public static int binarySearchMinimumLargestThanTarget(int[] arr, int target, int lb, int ub, int minDiff, int minIdx) {
        if (lb > ub) {
           return minIdx;
        } else {
            int mid = (lb+ub)/2;
            if (arr[mid] > target) {
                if (minDiff > (arr[mid] - target)) {
                    minDiff = (arr[mid] - target);
                    minIdx = mid;
                }
                return binarySearchMinimumLargestThanTarget(arr, target, lb, mid - 1, minDiff, minIdx);
            } else {
                return binarySearchMinimumLargestThanTarget(arr, target, mid+1, ub,  minDiff, minIdx);
            }
        }
    }
}
