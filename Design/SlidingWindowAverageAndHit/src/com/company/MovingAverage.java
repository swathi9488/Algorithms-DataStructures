package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by swathi on 6/20/16.
 */
public class MovingAverage {
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int queueSize;
    int sum;
    int windowSize;

    public MovingAverage(int k) {
        this.windowSize = k;
        this.sum = 0;
        this.queueSize = 0;
    }

    public void addNum(int num) {
        if (queueSize < windowSize) {
            sum += num;
            queue.add(num);
            queueSize++;
        } else {
            Integer removeEle = queue.poll();
            sum += num - removeEle;
            queue.add(num);

            Integer mapVal = map.get(removeEle);
            if (mapVal == 1) {
                map.remove(removeEle);
            } else {
                map.put(removeEle, mapVal - 1);
            }
        }

        Integer mapVal = map.get(num);
        if (mapVal == null) {
            map.put(num, 1);
        } else {
            map.put(num, mapVal + 1);
        }
    }

    public double getAverage() {
        if (queueSize < windowSize) {
            return (double) sum/queueSize;
        }

        return (double) sum/windowSize;
    }

    public boolean isPresent(int num) {
        return (map.get(num) != null);
    }

}
