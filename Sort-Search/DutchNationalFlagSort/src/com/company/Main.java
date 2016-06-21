package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = new int[]{2, 3, 1, 1, 2, 3, 1, 2, 3, 2, 1};
        arr = sortArray3(arr);

        int[] arr2 = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 2};
        arr2 = sortArray2(arr2);
        System.out.println(arr);
    }

    public static int[] sortArray3(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            // important: a[mid] not a[i]
            switch(arr[mid]) {
                case 1:
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    mid++;
                    low++;
                    break;
                case 2:
                    mid++;
                    break;
                case 3:
                    int t = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = t;
                    high--;
                    break;
            }
        }

        return arr;
    }

    public static int[] sortArray2(int[] arr) {
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            // important: a[mid] not a[i]
            switch(arr[mid]) {
                case 1:
                    mid++;
                    break;
                case 2:
                    int t = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = t;
                    high--;
                    break;
            }
        }

        return arr;
    }
}
