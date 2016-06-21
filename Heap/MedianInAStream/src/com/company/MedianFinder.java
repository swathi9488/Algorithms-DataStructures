package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    });
    double prevMedian = -1.0;

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2.compareTo(i1);
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        int balance = getBalanceCount();
        if (balance == 0) {
            if (num < prevMedian) {
                maxHeap.add(num);
                prevMedian = maxHeap.peek();
            } else {
                minHeap.add(num);
                prevMedian = minHeap.peek();
            }
        } else if (balance == -1) {
            if (num < prevMedian){
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
            prevMedian = (double) (maxHeap.peek() + minHeap.peek())/2;
        } else {
            if (num < prevMedian){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            prevMedian = (double) (maxHeap.peek() + minHeap.peek())/2;
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return prevMedian;
    }

    private int getBalanceCount() {
        if (maxHeap.size() == minHeap.size()) {
            return 0;
        } else if (maxHeap.size() < minHeap.size()) {
            return -1;
        } else {
            return 1;
        }
    }
}