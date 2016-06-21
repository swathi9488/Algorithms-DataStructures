package com.company;

import java.util.List;

/**
 * Created by swathi on 4/7/16.
 */
public class MinHeap {

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
    
    Integer getMin() {
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
        while (i > 0 && heapArray[i] < heapArray[getParent(i)]){
            int temp = heapArray[i];
            heapArray[i] = heapArray[getParent(i)];
            heapArray[getParent(i)] = temp;
            i = getParent(i);
        }
    }
    
    public void heapify(Integer i) {
        int left = getLeft(i);
        int right = getRight(i);
        int min = i;
        if (left < heapSize() && heapArray[min] > heapArray[left]) {
            min = left;
        }

        if (right < heapSize() && heapArray[min] > heapArray[right]) {
            min = right;
        }

        if (min != i) {
            int temp = heapArray[min];
            heapArray[min] = heapArray[i];
            heapArray[i] = temp;
            heapify(min);
        }
    }

    public Integer extractMin() {
        int min = heapArray[0];
        if (heapSize > 1) {
            heapArray[0] = heapArray[heapSize - 1];
            heapSize--;
            heapify(0);
        } else {
            heapArray[0] = null;
            heapSize--;
        }
        return min;
    }
}
