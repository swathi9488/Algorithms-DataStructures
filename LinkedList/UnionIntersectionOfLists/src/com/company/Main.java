package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[]{1, 5, 6, 8, 8}));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{2, 3, 5, 7, 8, 8}));
        System.out.println(new Solution().getIntersection(list1, list2));
        System.out.println(new Solution().getUnion(list1, list2));
    }
}
