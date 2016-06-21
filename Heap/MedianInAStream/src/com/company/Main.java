package com.company;

public class Main {

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();
        int prevMedian = -1;
        int[] input = {5, 15, 1, 3, 2, 8, 7, 27, 90, 78, 65};
        for (int i = 0; i < input.length; i++) {
            int median = getMedian(minHeap, maxHeap, input[i], prevMedian);
            prevMedian = median;
            System.out.println("Median = " + median);
        }

        System.out.println("=====Leet Code solution=====");
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 0; i < input.length; i++) {
            medianFinder.addNum(input[i]);
            System.out.println("Median = " + medianFinder.findMedian());
        }
    }

    private static int getMedian(MinHeap minHeap, MaxHeap maxHeap, int value, int prevMedian) {
        int balanced = getBalanced(maxHeap.heapSize(), minHeap.heapSize());

        if (balanced == 0) {
            if (value < prevMedian) {
                maxHeap.insert(value);
                return maxHeap.getMax();
            } else {
                minHeap.insert(value);
                return minHeap.getMin();
            }
        } else if (balanced == -1) { //left (MaxHeap) has lesser elements than right(MinHeap)
            if (value < prevMedian) {
                maxHeap.insert(value);
            } else {
                int minHeapMed = minHeap.extractMin();
                maxHeap.insert(minHeapMed);
                minHeap.insert(value);
            }
            return (maxHeap.getMax() + minHeap.getMin())/2;
        } else { // left (MaxHeap) has more elements
            if (value < prevMedian) {
                int maxHeapMed = maxHeap.extractMax();
                minHeap.insert(maxHeapMed);
                maxHeap.insert(value);
            } else {
                minHeap.insert(value);
            }
            return (maxHeap.getMax() + minHeap.getMin())/2;
        }
    }

    private static int getBalanced(int left, int right) {
        if (left == right) {
            return 0;
        }

        return (left > right)?1:-1;
    }
}
