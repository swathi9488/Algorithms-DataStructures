package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    //http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
    public static void main(String[] args) {
	// write your code here
        int[] input = new int[] {3, 2, 0, 0, 1, 1, 3, 4};
        //int[] input = new int[] {3, 2, 1, 4, 1, 1, 3, 4};
        printDuplicates(input);
    }

    public static void printDuplicates (int[] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            // case when i = 6, abs(input[3]) = 8
            if (input[Math.abs(input[i])%n] >= 0) {
                if (input[Math.abs(input[i])%n] == 0) {
                    // cannot negate 0, hence store -n
                    input[Math.abs(input[i])%n] = -n;
                } else {
                    input[Math.abs(input[i])%n] = -input[Math.abs(input[i])%n];
                }
            } else {
                if (Math.abs(input[i]) == n) {
                    System.out.println(0);
                } else {
                    System.out.println(Math.abs(input[i]));
                }
            }
        }

        // Follow Up
        System.out.println("Missing Numbers in range:");
        for (int i = 0; i < n; i++) {
            if (input[i] >= 0) {
              System.out.println(i);
            }
        }
    }
}

