package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String input = "I am swathi        somerandom garbage";
        char[] inputArr = input.toCharArray();
        replaceString(inputArr, 13);
        System.out.println(inputArr);
    }

    private static void replaceString (char[] input, int length) {
        // count spaces
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == ' ') {
               spaceCount++;
            }
        }

        if (spaceCount == 0) {
            return;
        }

        int newLength = length + 2 * spaceCount;
        input[newLength] = '\0';
        int start = length - 1;
        int freeLocation = newLength - 1;

        while (start >= 0) {
            if (input[start] != ' ') {
                input[freeLocation--] = input[start];
            } else {
                input[freeLocation--] = '0';
                input[freeLocation--] = '2';
                input[freeLocation--] = '%';
            }
            start--;
        }

    }
}
