package com.company;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(getLongestCommonSubsequence("dcabca", "dadcacdcabc", new HashMap<>()));
    }

    public static String getLongestCommonSubsequence(String a, String b, Map<Pair<String, String>, String> memoization) {
        if (a == null || a.isEmpty()) {
            return "";
        }

        if (b == null || b.isEmpty()) {
            return "";
        }

        // memoization
        String memoizedValue = memoization.get(new Pair<>(a, b));
        if (memoizedValue != null) {
            return memoizedValue;
        }

        int aLength = a.length();
        int bLength = b.length();

        StringBuilder sb = new StringBuilder();
        if (a.charAt(aLength - 1) == b.charAt(bLength - 1)) {
            String subSequence = getLongestCommonSubsequence(a.substring(0, aLength - 1), b.substring(0, bLength - 1), memoization);
            sb.append(subSequence);
            sb.append(a.charAt(aLength - 1));
        } else {
            String case1 = getLongestCommonSubsequence(a.substring(0, aLength), b.substring(0, bLength - 1), memoization);
            String case2 = getLongestCommonSubsequence(a.substring(0, aLength - 1), b.substring(0, bLength), memoization);
            String subSequence = (case1.length() > case2.length()) ? case1: case2;
            sb.append(subSequence);
        }

        // remember result for future redundant recursive calls
        memoization.put(new Pair<>(a, b), sb.toString());
        return sb.toString();
    }
}
