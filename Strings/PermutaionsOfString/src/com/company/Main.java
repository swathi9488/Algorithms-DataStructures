
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "abcdefghijklmnopqrstuvwxyz";
        /*Set<String> permutations = permutations(s);
        System.out.println("==== Permutations ===");
        System.out.println(permutations);
        System.out.println(permutations.size());*/

        String s1 = "abc";
        System.out.println("==== Permutations ===");
        permutationsOptimized(s1, 0, s1.length() - 1);

        Set<String> powerSet = powerSet(s1);
        System.out.println("==== Powerset ===");
        System.out.println(powerSet);
        System.out.println(powerSet.size());

        System.out.println("==== Permutations WIth duplicates ===");
        new Solution().permuteUnique(new int[] {1, 2, 1, 1});
    }

    public static void permutationsOptimized(String s, int start, int end) {
        if (start == end) {
            System.out.println(s);
        } else {
            for (int i = start; i <= end; i++) {
                s = swap(s.toCharArray(), start, i);
                permutationsOptimized(s, start + 1, end);
                s = swap(s.toCharArray(), start, i);
            }
        }
    }

    public static String swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return new String(s);
    }

    public static Set<String> permutations(String s) {
        if (s.length() <= 1) {
            Set<String> list = new HashSet<>();
            list.add(s);
            return list;
        }

        Set<String> permuationList = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            // in "abcd" the base string is b, then permute is (a) + (cd),
            // then calculate permutations of (acd) and append b to each item in that list
            // do the above wich each character as base string
            String baseString = String.valueOf(s.charAt(i));

            String permute;
            if (i != 0) {
                permute = s.substring(0, i) + s.substring(i+1, s.length());
            } else {
                permute = s.substring(i+1, s.length());
            }

            Set<String> subPermutations = permutations(permute);
            permuationList.addAll(subPermutations.stream().map(sub -> baseString + sub).collect(Collectors.toList()));
        }

        return permuationList;
    }

    public static Set<String> powerSet(String s) {
        if (s.length() <= 1) {
            Set<String> set = new HashSet<>();
            set.add(s);
            set.add("");
            return set;
        }

        //NOTE: no loop required! as you can see below :)
        // this logic is similar to how binary numbers are formed [1(0,1), 0(0,1)] => [10,11,00,01]
        // a {bc} => a {b {c}} => a {b {c, ""}} => {a {bc, b"", ""c, ""}} => {abc, ab"", a""c, a"", bc, b"", ""c, ""} then
        Set<String> powerSet = new HashSet<>();
        int i = 0;
        String baseString = String.valueOf(s.charAt(i));
        String subStr = s.substring(i+1, s.length());
        Set<String> subPowerSet = powerSet(subStr);
        for (String sub: subPowerSet) {
            powerSet.add(baseString + sub);
        }
        powerSet.addAll(subPowerSet);

        return powerSet;
    }

    private static void permutationsOptimized1(int[] nums, int start, int end, List<List<Integer>> result) {
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < end+1; i++) {
                list.add(nums[i]);
            }
            result.add(list);
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                permutationsOptimized1(nums, start + 1, end, result);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
