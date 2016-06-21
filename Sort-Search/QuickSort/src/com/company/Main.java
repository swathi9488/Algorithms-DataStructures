package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {3, 80, 40, 25, 70, 30, 45, 2, 78, 90, 65, 234, 150};
        quickSortRandomized(input, 0, input.length-1);
        for (int i = 0; i <input.length; i++) {
            System.out.print(input[i] + "\t");
        }
    }

    public static void quickSort(int[] arr, int lb, int ub) {
        if (lb == ub) {
            return;
        }

        int i = partitionAndGetIdx(arr, lb, ub);

        if (i != lb) {
            quickSort(arr, lb, i - 1);
        }

        if (i != ub) {
            quickSort(arr, i + 1, ub);
        }
    }

    public static void quickSortRandomized(int[] arr, int lb, int ub) {
        if (lb == ub) {
            return;
        }

        // generate a random index between lb and ub inclusive
        Random random = new Random();
        int randIdx = random.nextInt(ub-lb+1)+lb;

        // swap the element at random index and element at the last (the element at the last is always the pivot)
        int temp = arr[randIdx];
        arr[randIdx] = arr[ub];
        arr[ub] = temp;

        int i = partitionAndGetIdx(arr, lb, ub);

        if (i != lb) {
            quickSortRandomized(arr, lb, i - 1);
        }

        if (i != ub) {
            quickSortRandomized(arr, i + 1, ub);
        }
    }

    static int partitionAndGetIdx(int[] arr, int lb, int ub) {
        int i = lb - 1;
        int j = lb;
        int pivot = arr[ub];
        while (j != ub) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        i++;
        arr[ub] = arr[i];
        arr[i] = pivot;
        return i;
    }
}
