package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println(canBuildRansomNote("can give us", "give us Can"));
        System.out.println(canBuildRansomNoteOptimized("can give us your money back.", "i can c ur monk"));
    }

    public static boolean canBuildRansomNote(String magazineString, String randsomString) {
        int rLen = randsomString.length();
        int mLength = magazineString.length();

        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int i = 0; i < mLength; i++) {
            char current = magazineString.charAt(i);
            if (current != ' ') {
                Integer mapValue = charFrequency.get(current);
                if (mapValue == null) {
                    charFrequency.put(current, 1);
                } else {
                    charFrequency.put(current, mapValue+1);
                }
            }
        }

        for (int i = 0; i < rLen; i++) {
            char current = randsomString.charAt(i);
            if (current != ' ') {
                Integer mapValue = charFrequency.get(current);
                if (mapValue == null || mapValue == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean canBuildRansomNoteOptimized(String magazineString, String randsomString) {
        int rLen = randsomString.length();
        int mLength = magazineString.length();

        Map<Character, Integer> charFrequency = new HashMap<>();

        int i = 0;
        int j = 0;
        while (i != rLen) {
            if (randsomString.charAt(i) == ' ') {
                i++;
            } else if (j != mLength && randsomString.charAt(i) == magazineString.charAt(j)) {
                i++;
                j++;
            } else {
                Integer mapValue = charFrequency.get(randsomString.charAt(i));
                if (mapValue != null) {
                    charFrequency.put(randsomString.charAt(i), mapValue - 1);
                    i++;
                } else {
                    while (j != mLength && randsomString.charAt(i) != magazineString.charAt(j)) {
                        Integer magValue = charFrequency.get(magazineString.charAt(j));
                        if (magValue != null) {
                            charFrequency.put(magazineString.charAt(j), magValue + 1);
                        } else {
                            charFrequency.put(magazineString.charAt(j), 1);
                        }
                        j++;
                    }
                    if (j == mLength) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
