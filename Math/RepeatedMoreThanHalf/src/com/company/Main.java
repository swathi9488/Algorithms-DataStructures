package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(getElementRepeatedMoreThanHalf(new int[]{5, 5, 5, 5, 3, 3, 3, 3, 3}));
    }

    //when an element is repeated in more than half of the array, there needs to be atleast one pair where they are next to each other
    private static int getElementRepeatedMoreThanHalf(int[] input) {
        int candidateIdx = -1;
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (count == 0) {
                candidateIdx = i;
                count = 1;
            } else {
                if (input[i] == input[candidateIdx]) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == input[candidateIdx]) {
                count++;
            }
        }


        return (count >= (input.length + 1)/2)?input[candidateIdx]:-1;
    }
}
