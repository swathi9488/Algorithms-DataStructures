package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "AABCDEBAZ";
        System.out.println(lps(s, 0, s.length() - 1, new HashMap<>()));
        System.out.println(lpsVal(s, 0, s.length() - 1, new HashMap<>()));

    }

    private static int lps(String s, int i, int j, Map<String, Integer> memoize) {
        if (i == j) {
            return 1;
        }

        String temp = s.substring(i, j+1);
        if (memoize.get(temp) != null) {
            return memoize.get(temp);
        }

        if (s.charAt(i) == s.charAt(j) && (i+1) == j) {
            memoize.put(temp, 2);
            return 2;
        }

        if(s.charAt(i) == s.charAt(j)) {
            int count = 2 + lps(s, i+1, j-1, memoize);
            memoize.put(temp, count);
            return count;
        }

        int count = Math.max(lps(s, i, j-1, memoize), lps(s, i+1, j, memoize));
        memoize.put(temp, count);
        return count;
    }

    private static String lpsVal(String s, int i, int j, Map<String, String> memoize) {
        if (i == j) {
            return String.valueOf(s.charAt(i));
        }

        String temp = s.substring(i, j+1);
        if (memoize.get(temp) != null) {
            return memoize.get(temp);
        }

        if (s.charAt(i) == s.charAt(j) && (i+1) == j) {
            memoize.put(temp, temp);
            return temp;
        }

        if(s.charAt(i) == s.charAt(j)) {
            String result = String.valueOf(s.charAt(i)) + lpsVal(s, i+1, j-1, memoize) + String.valueOf(s.charAt(j));
            memoize.put(temp, result);
            return result;
        }

        String left = lpsVal(s, i, j-1, memoize);
        String right = lpsVal(s, i+1, j, memoize);
        String result = (left.length() > right.length())?left:right;
        memoize.put(temp, result);
        return result;
    }
}
