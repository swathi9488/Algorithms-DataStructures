package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(9, 12));
        System.out.println(getRange(intervals));
    }

    private static int getRange(List<Interval> intervals) {

        int range = 0;
        Interval prev = null;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return new Integer(i1.start).compareTo(new Integer(i2.start));
            }
        });

        for (Interval interval : intervals) {
            if (prev == null) {
                prev = interval;
            } else if (interval.start <= prev.end) {
                prev.end = Math.max(interval.end, prev.end);
            } else {
                // corner case when (1, 1), (2, 2)
                int diff = prev.end - prev.start + 1;
                range += diff;
                prev = interval;
            }
        }

        if (prev != null) {
            int diff = prev.end - prev.start + 1;
            range += diff;
        }

        return range;
    }

    static class Interval{
        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

}
