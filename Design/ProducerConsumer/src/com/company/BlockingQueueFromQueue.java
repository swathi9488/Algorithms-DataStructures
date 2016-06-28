package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by swathi on 6/27/16.
 */
public class BlockingQueueFromQueue<T> implements BlockingQueue<T> {
    private int maxCapacity;
    private Queue<T> unboundedQueue;

    public BlockingQueueFromQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.unboundedQueue = new LinkedList<>();
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (unboundedQueue.size() == maxCapacity) {
            System.out.println("Producer waiting");
            wait();
        }
        unboundedQueue.add(item);
        System.out.println("I produced value:" + item);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (unboundedQueue.size() == 0) {
            System.out.println("Consumer waiting");
            wait();
        }
        T item = unboundedQueue.poll();
        System.out.println("I consumed value:" + item);
        notifyAll();
        return item;
    }
}
