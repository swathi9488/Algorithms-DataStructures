package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by swathi on 5/21/16.
 */
public class Solution {

    public boolean doesTrinagleExist(List<Point> points) {
        Point firstPoint = points.get(0);
        int i = 0;

        // eliminate duplicates [(0, 0), (0,0), (1,1)]
        while (i != points.size() && isDuplicate(firstPoint, points.get(i))) {
            i++;
        }

        if (i == points.size()) {
            return false;
        }

        double slope = getSlope(firstPoint, points.get(i));
        //[(0,0), (1, 1), (0, 0)]
        for (int count = i+1; count < points.size(); count++) {
           if (!isDuplicate(firstPoint, points.get(count)) && getSlope(firstPoint, points.get(count)) != slope) {
               return true;
           }
        }

        return false;

    }

    private boolean isDuplicate(Point a, Point b) {
        return (a.x == b.x) && (a.y == b.y);
    }

    private Double getSlope(Point a, Point b) {
        int yIntercept = b.y - a.y;
        int xIntercept = b.x - a.x;
        if (xIntercept == 0) {
            return Double.MAX_VALUE;
        }

        double slope = ((double) yIntercept)/xIntercept;
        return slope;
    }

    // when side lengths are given
    public int getTriangleCount(List<Integer> sideLengths) {
        sideLengths.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        int count = 0;
        for (int i = 0; i < sideLengths.size() - 2; i++) {
            int k = i+2;
            for (int j = i+1; j < sideLengths.size(); j++) {
                while(k < sideLengths.size() && sideLengths.get(i) + sideLengths.get(j) > sideLengths.get(k)) {
                    k++;
                }
                printTriangles(sideLengths, i, j, k);
                count += k - j - 1;
            }
        }

        return count;

    }

    private void printTriangles(List<Integer> nums, int i, int j, int k) {
        for (int count = j+1; count < k; count++) {
            System.out.println(String.format("(%d, %d, %d)", nums.get(i), nums.get(j), nums.get(count)));
        }
    }
}
