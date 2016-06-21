package com.company;

/**
 * Created by swathi on 5/15/16.
 */
public class Solution {
    public String reverseWords(String st) {
        char[] s = st.toCharArray();
        s = reverseString(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                s = reverseString(s, start, i-1);
                start = i+1;
            }
        }

        s = reverseString(s, start, s.length - 1);
        return new String(s);
    }

    private char[] reverseString(char[] s, int start, int end) {
        for (int i = 0; i < (end - start + 1)/2; i++) {
            char temp = s[start + i];
            s[start + i] = s[end - i];
            s[end - i] = temp;
        }
        return s;
    }
}
