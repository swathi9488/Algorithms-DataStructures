package com.company;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Pair, Integer> memoization = new HashMap<>();

    public static void main(String[] args) {
	// write your code here
        Integer answer = countPartitions(4, 4);
        System.out.print(answer);
    }

    // Count partitions of n where the partition number used is <= k For eg: (6, 2)
    public static Integer countPartitions(int n, int k) {
        if (n < 0 || k == 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }


        Pair nkPair = new Pair(n, k);
        if (memoization.get(nkPair) != null) {
            return memoization.get(nkPair);
        }

        Integer numPartiions = countPartitions(n-k, k) + countPartitions(n, k-1);
        memoization.put(nkPair, numPartiions);
        return numPartiions;
    }
}
