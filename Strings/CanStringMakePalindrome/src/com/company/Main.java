package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String input = "nittiniii";
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Integer value = charMap.get(input.charAt(i));
            if (value != null) {
                charMap.put(input.charAt(i), ++value);
            } else {
                charMap.put(input.charAt(i), 1);
            }
        }

        boolean isPalindrome = true;
        boolean foundOdd = false;
        for (Map.Entry<Character, Integer> mapEntry : charMap.entrySet()) {
            int occurance = mapEntry.getValue();
            if (occurance % 2 != 0) {
                if (foundOdd) {
                    isPalindrome = false;
                    break;
                }  else {
                    foundOdd = true;
                }
            }
        }

        System.out.print(input + " Palindrome ?: " + isPalindrome);
    }
}
