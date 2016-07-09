package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {3, 2, 45, 67, 8, 65, 4, 8, 7};
        int val = findKthSmallest(arr, 0, arr.length - 1, 1);
        System.out.println(val);
        int val1 = findKthLargest(arr, 0, arr.length - 1, 1);
        System.out.println(val1);
    }

    static int findKthSmallest(int[] arr, int lb, int ub, int k) {

        if (k > 0 && k <= ub-lb+1) {
            Random random = new Random();
            int randIdx = random.nextInt(ub - lb + 1) + lb;
            int temp = arr[randIdx];
            arr[randIdx] = arr[ub];
            arr[ub] = temp;

            int pivot = arr[ub];
            int i = lb - 1;
            int j = i + 1;
            while (j != ub) {
                if (arr[j] <= pivot) {
                    i++;
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
                j++;
            }

            i++;
            arr[ub] = arr[i];
            arr[i] = pivot;

            if (k - 1 == i - lb) {
                return arr[i];
            } else if (k - 1 < i - lb) {
                return findKthSmallest(arr, lb, i - 1, k);
            } else {
                return findKthSmallest(arr, i + 1, ub, k - (i - lb) - 1);
            }
        }
        return -1;
    }

    static int findKthLargest(int[] arr, int lb, int ub, int k) {

        if (k > 0 && k <= ub-lb+1) {
            Random random = new Random();
            int randIdx = random.nextInt(ub - lb + 1) + lb;
            int temp = arr[randIdx];
            arr[randIdx] = arr[ub];
            arr[ub] = temp;

            int pivot = arr[ub];
            int i = lb - 1;
            int j = i + 1;
            while (j != ub) {
                if (arr[j] >= pivot) {
                    i++;
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
                j++;
            }

            i++;
            arr[ub] = arr[i];
            arr[i] = pivot;

            if (k - 1 == i - lb) {
                return arr[i];
            } else if (k - 1 < i - lb) {
                return findKthLargest(arr, lb, i - 1, k);
            } else {
                return findKthLargest(arr, i + 1, ub, k - (i - lb) - 1);
            }
        }
        return -1;
    }
}
