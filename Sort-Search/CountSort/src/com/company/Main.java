package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] result = countSort(new int[]{0, 1, 2, 3, 3, 4, 2, 3 ,1, 0}, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
        System.out.println();

        // sort numbers in the range 30 - 50
        int[] resultMod = modifiedRangeCountSort(new int[]{30, 31, 32, 33, 33, 34, 32, 33 ,31, 30, 50, 40, 47, 45, 42, 41, 42}, 30, 50);
        for (int i = 0; i < resultMod.length; i++) {
            System.out.print(resultMod[i] + "\t");
        }
    }

    public static int[] countSort (int[] input, int range) {
        int size = input.length;
        int[] countArr = new int[range + 1];
        int[] result = new int[size];

        //Phase 1: Count Phase
        for (int i = 0; i < size; i++) {
            countArr[input[i]] += 1;
        }

        //Phase 2: Modify Count Array
        for (int i = 1; i < range+1; i++) {
            countArr[i] = countArr[i-1] + countArr[i];
        }

        for (int i = size - 1; i >=0; i--) {
            result[countArr[input[i]] - 1] = input[i];
            countArr[input[i]] -= 1;
        }

        return result;

    }

    public static int[] modifiedRangeCountSort (int[] input, int startRange, int endRange) {
        int size = input.length;
        int[] countArr = new int[(endRange - startRange) + 1];
        int[] result = new int[size];

        //Phase 1: Count Phase
        for (int i = 0; i < size; i++) {
            countArr[input[i] - startRange] += 1;
        }

        //Phase 2: Modify Count Array
        for (int i = 1; i < (endRange - startRange) + 1; i++) {
            countArr[i] = countArr[i-1] + countArr[i];
        }

        for (int i = size - 1; i >=0; i--) {
            result[countArr[input[i] - startRange] - 1] = input[i];
            countArr[input[i] - startRange] -= 1;
        }

        return result;

    }
}
