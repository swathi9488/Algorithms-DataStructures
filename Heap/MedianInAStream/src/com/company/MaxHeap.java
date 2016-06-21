package com.company;

/**
 * Created by swathi on 4/7/16.
 */
public class MaxHeap {
    Integer[] heapArray = new Integer[100000];
    Integer heapSize = 0;

    Integer getParent (int i) {
        return (i-1)/2;
    }

    Integer getLeft(int i) {
        return 2*i + 1;
    }

    Integer getRight(int i) {
        return 2*i + 2;
    }

    Integer getMax() {
        if (heapSize == 0) {
            return null;
        }

        return heapArray[0];
    }

    Integer heapSize() {
        return heapSize;
    }

    public void insert(Integer value) {
        heapArray[heapSize] = value;
        heapSize++;
        int i = heapSize - 1;
        while (i > 0 && heapArray[i] > heapArray[getParent(i)]){
            int temp = heapArray[i];
            heapArray[i] = heapArray[getParent(i)];
            heapArray[getParent(i)] = temp;
            i = getParent(i);
        }
    }

    public void heapify(Integer i) {
        int left = getLeft(i);
        int right = getRight(i);
        int max = i;
        if (left < heapSize() && heapArray[max] < heapArray[left]) {
            max = left;
        }

        if (right < heapSize() && heapArray[max] < heapArray[right]) {
            max = right;
        }

        if (max != i) {
            int temp = heapArray[max];
            heapArray[max] = heapArray[i];
            heapArray[i] = temp;
            heapify(max);
        }
    }

    public Integer extractMax() {
        int max = heapArray[0];
        if (heapSize > 1) {
            heapArray[0] = heapArray[heapSize - 1];
            heapSize--;
            heapify(0);
        } else {
            heapArray[0] = null;
            heapSize--;
        }
        return max;
    }
}
