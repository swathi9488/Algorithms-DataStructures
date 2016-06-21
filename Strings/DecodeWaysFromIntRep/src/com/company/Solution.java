package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by swathi on 6/7/16.
 */
public class Solution {
    public int getDecodeCount(String s) {
        Map<Integer, String> alphabetMap = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            char c = (char) (i - 1 + 97);
            alphabetMap.put(i, String.valueOf(c));
        }
        alphabetMap.put(27, "aa");
        return getDecodeCount(s, new HashMap<>(), alphabetMap, 2);
    }

    private int getDecodeCount(String s, Map<String, Integer> memoize,
                           Map<Integer, String> alphabetMap, int k) {
        if (s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        if (memoize.get(s) != null) {
            return memoize.get(s);
        }

        int count = 0;
        if (s.length() <= k) {
            if (alphabetMap.get(Integer.parseInt(s)) != null) {
                count++;
            }
        }

        for (int i = 1; i <= k; i++) {
            if (alphabetMap.get(Integer.parseInt(s.substring(0, i))) != null) {
                count += getDecodeCount(s.substring(i, s.length()), memoize, alphabetMap, k);
            }
        }

        memoize.put(s, count);
        return count;
    }
}
