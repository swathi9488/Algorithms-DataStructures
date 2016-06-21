package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 3));
        points.add(new Point(12, 30));
        points.add(new Point(40, 50));
        points.add(new Point(5, 1));
        points.add(new Point(5, 0));
        points.add(new Point(12, 10));
        points.add(new Point(3, 4));

        System.out.println(getClosestPair(points));
        System.out.println(kNearestPointsToOrigin(points, 4));

    }

    private static List<Point> kNearestPointsToOrigin(List<Point> points, int k) {
        Point origin = new Point(0, 0);
        PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Float.compare(dist(o2, origin), dist(o1, origin));
            }
        });

        List<Point> pointsK = points.subList(0, k);
        queue.addAll(pointsK);

        for (int i = k; i < points.size(); i++) {
            Point currMax = queue.peek();
            if (dist(currMax, origin) > dist(points.get(i), origin)) {
                queue.poll();
                queue.offer(points.get(i));
            }
        }

        List<Point> result = new ArrayList<>();
        for(Point p : queue) {
            result.add(p);
        }

        return result;
    }

    private static float getClosestPair(List<Point> points) {

        //This WONT work!!
        /*
            List<Point> pointsX = points;
            List<Point> pointsY = points;
            pointsX.sort()
            pointsY.sort()
            this is because PointX and PointsY point ot the same object points.
            The first sort sorts pointX by x coord. and changes both pointX and PointY to be sorted by x
            The second sort sorts pointY by y, since both pointx and pointy point to the same object,
            now both of them are sorted by Y.
         */
        //So you have to create a shallow copy by doing the following:
        List<Point> pointsX = new ArrayList<>(points);
        List<Point> pointsY = new ArrayList<>(points);

        pointsX.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x == o2.x) {
                    return new Integer(o1.y).compareTo(new Integer(o2.y));
                }
                return new Integer(o1.x).compareTo(new Integer(o2.x));
            }
        });

        pointsY.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.y == o2.y) {
                    return new Integer(o1.x).compareTo(new Integer(o2.x));
                }
                return new Integer(o1.y).compareTo(new Integer(o2.y));
            }
        });

        return getClosestPairUtil(pointsX, pointsY, points.size());
    }

    private static float getClosestPairUtil(List<Point> pointsX, List<Point> pointsY, int size) {
        if (size <= 3) {
            return bruteForce(pointsX, size);
        }

        int mid = size/2;
        Point midPoint = pointsX.get(mid);

        List<Point> pointsYLeft = new ArrayList<>();
        List<Point> pointsYRight = new ArrayList<>();
        for (Point p : pointsY) {
            if (p.x <= midPoint.x) {
                pointsYLeft.add(p);
            } else {
                pointsYRight.add(p);
            }
        }

        float dl = getClosestPairUtil(pointsX,pointsYLeft,mid);
        float dr = getClosestPairUtil(pointsX.subList(mid, size - 1),pointsYRight,size - mid);

        float d = Math.min(dl, dr);

        List<Point> strip = pointsY;
        return Math.min(d, getStripClosest(strip, d));
    }

    private static float bruteForce(List<Point> pointsX, int size) {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < pointsX.size(); i++) {
            for(int j = i+1; j < pointsX.size(); j++) {
                float distance = dist(pointsX.get(i), pointsX.get(j));
                if (distance < min) {
                    min = distance;
                }
            }
        }

        return min;
    }

    private static float getStripClosest(List<Point> strip, float d) {
        float min = d;
        for (int i = 0; i < strip.size(); i++) {
            for(int j = i+1; j < strip.size() && strip.get(j).y - strip.get(i).y < min; j++) {
                float distance = dist(strip.get(i), strip.get(j));
                if (distance < min) {
                    min = distance;
                }
            }
        }

        return min;

    }

    private static float dist(Point point1, Point point2) {
        int xDiff = point1.x - point2.x;
        int yDiff = point1.y - point2.y;
        return (float) Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }
}
