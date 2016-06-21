package com.company;

public class Main {

    public static void main(String[] args) {
	    //int[] input = {1, 1, 1, 2, 2, 2, 3, 5, 6, 6, 7, 7, 9};
        int[] input = {1, 1, 1, 2, 2, 3, 4, 5};
        int pointer = getSortedArrayWithoutDuplicates(input);

        for (int i = 0; i <= pointer; i++) {
            System.out.print(input[i] + "\t");
        }
    }

    private static int getSortedArrayWithoutDuplicates(int[] input) {
        int size = input.length;

        if (size == 0) {
            return -1;
        }
        int curr = 0;
        int next = curr + 1;

        while (curr != size && next != size) {
            if (input[curr] != input[next]) {
                input[++curr] = input[next];
                next++;
            } else {
                while (next != size && input[curr] == input[next]){
                    next++;
                }

                if (next == size) {
                    curr--;
                } else {
                    int temp = input[curr];
                    input[curr] = input[next];
                    input[next] = temp;
                    next++;
                }
            }
        }

        return curr;
    }

}

