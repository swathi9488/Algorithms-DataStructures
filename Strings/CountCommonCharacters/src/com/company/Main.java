package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("\n" + countCommonChars(new String[]{"treee", "beet", "treel"}));
        System.out.println("\n" + countSetIntersection(new String[]{"treee", "beet", "treel"}));

    }

    private static int countCommonChars(String[] strs) {
        int[] map = new int[256];
        int result = 0;
        for (String str : strs) {
            Set<Character> unique = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                if (!unique.contains(str.charAt(i))) {
                    unique.add(str.charAt(i));
                    map[str.charAt(i)] += 1;
                }
            }
        }

        for (int i = 0; i < 256; i++) {
            if (map[i] == strs.length) {
                result++;
                System.out.print((char) i + "\t");
            }
        }

        return result;
    }

    private static int countSetIntersection(String[] strs) {
        int[] map = new int[256];
        int[][] intermediateResult = new int[strs.length][256];
        int result = 0;

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                map[strs[i].charAt(j)] += 1;
                intermediateResult[i][strs[i].charAt(j)] += 1;
            }
        }

        for (int i = 0; i < 256; i++) {
            if (map[i] >= strs.length) {
                int countPerItem = map[i] / strs.length;
                int j;
                for (j = 0; j < strs.length; j++) {
                    if (intermediateResult[j][(char) i] < countPerItem) {
                        break;
                    }
                }

                if (j == strs.length) {
                    System.out.print((char) i + "\t");
                    result += countPerItem;
                }

            }
        }

        return result;
    }
}
