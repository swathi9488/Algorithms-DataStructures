package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        List<Integer> sideLengths = Arrays.asList(10, 23, 100, 21, 200, 300, 101, 22);
        System.out.println(solution.getTriangleCount(sideLengths));

        //List<Point> points = Arrays.asList(new Point(4, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4));
        //List<Point> points = Arrays.asList(new Point(4, 0), new Point(1, 1), new Point(-2, 2), new Point(4, 1));
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(0, 0), new Point(1, 1), new Point(2, 2));
        System.out.println(solution.doesTrinagleExist(points));
    }


}
