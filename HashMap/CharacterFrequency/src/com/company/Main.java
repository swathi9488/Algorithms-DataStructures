package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
	// write your code here
        printFrequency("swathisisreallylongandcoolaboutyouthatyoucangodiewithher");
        System.out.println(isPalindrome("swatrqtaws"));

    }

    public static void printFrequency(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            Integer mapVal = charMap.get(s.charAt(i));
            if (mapVal != null) {
                charMap.put(s.charAt(i), mapVal + 1);
            } else {
                charMap.put(s.charAt(i), 1);
            }
        }

        List<Map.Entry<Character, Integer>> sortedChars = new LinkedList<>(charMap.entrySet());
        Collections.sort(sortedChars, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                if (entry1.getValue() == entry2.getValue()) {

                    // smaller of the two characters is printed first
                    return entry1.getKey().compareTo(entry2.getKey());
               }

                // character with greater frequency is printed first
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        for (Map.Entry<Character, Integer> entry : sortedChars) {
            System.out.println(String.format("%s : %d", entry.getKey(), entry.getValue()));
        }
    }

    public static boolean isPalindrome (String input) {
        int length = input.length();
        if (input == null || length <= 1) {
            return true;
        }

        for (int i = 0; i < length/2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
