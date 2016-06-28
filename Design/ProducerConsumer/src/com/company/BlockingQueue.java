package com.company;

/**
 * Created by swathi on 6/27/16.
 */
public interface BlockingQueue<T> {
    public void enqueue(T item) throws InterruptedException;
    public T dequeue() throws InterruptedException;
}
