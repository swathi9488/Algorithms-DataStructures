package com.company;

import javafx.scene.control.RadioMenuItem;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = new int[]{6, 5, 1, 2, 4, 3, 65, 4, 23, 65};
        //printTop3(arr);
        printTop3Optimized(arr);
        System.out.print("Done");
    }

    public static void printTop3(int[] arr) {
        if (arr.length < 3) {
            System.out.println("Not enough elements");
        }

        for (int k = 0; k < 3; k++) {
            int end = arr.length - k;
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            for (int i = 0; i < end; i++) {
                if (max <= arr[i]) {
                    max = arr[i];
                    maxIdx = i;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[end-1];
            arr[end-1] = temp;
            System.out.println(arr[end-1]);
        }
    }

    public static void printTop3Optimized(int[] arr) {
        if (arr.length < 3) {
            System.out.println("Not enough elements");
        }

        int idx = findKthLargestElement(arr, 0, arr.length - 1, 3);

        for (int i = 0; i <= idx; i++) {
            System.out.println(arr[i]);
        }


    }

    public static int findKthLargestElement(int[] arr, int lb, int ub, int k) {
        if (k > 0 && k <= ub-lb+1) {
            Random rand = new Random();
            int randIdx = rand.nextInt(ub-lb+1) + lb;

            int temp = arr[randIdx];
            arr[randIdx] = arr[ub];
            arr[ub] = temp;

            int pivot = arr[ub];
            int i = lb - 1;
            int j = i + 1;

            while (j < ub) {
                if (arr[j] >= pivot) {
                    i++;
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;

                }
                j++;
            }
            i++;
            arr[ub] = arr[i];
            arr[i] = pivot;

            if (k - 1 == i - lb) {
                return i;
            } else if (k - 1 < i - lb) {
                return findKthLargestElement(arr, lb, i - 1, k);
            } else {
                return findKthLargestElement(arr, i + 1, ub, k - 1 - (i - lb));
            }
        }

        return -1;
    }
}
