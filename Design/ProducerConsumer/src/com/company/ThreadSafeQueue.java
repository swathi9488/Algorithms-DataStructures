package com.company;

/**
 * Created by swathi on 6/26/16.
 */
public class ThreadSafeQueue<T> {
    private Node<T> head, tail;
    private static int MAX_QUEUE_SIZE = 10;
    int size;

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public synchronized void enqueue(final T val) throws InterruptedException {
        while (size == MAX_QUEUE_SIZE) {
            System.out.println("Producer waiting");
            wait();
        }

        final Node<T> node = new Node(val);
        if (head != null) {
            tail.next = node;
            tail = node;
        } else {
            head = tail = node;
        }
        size++;

        // notify the threads that something has been produced
        System.out.println("I produced value:" + node);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (size == 0) {
            System.out.println("Consumer waiting");
            wait();
        }

        final Node<T> valueToRemove = head;
        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = head;
            }
        }

        if (valueToRemove == null) {
            throw new IllegalStateException("You cannot consume when nothing was produced!!");
        }

        size--;
        System.out.println("I consumed value:" + valueToRemove);
        notifyAll();
        return valueToRemove.value;
    }
}
