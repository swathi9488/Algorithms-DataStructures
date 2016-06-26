package com.company;

/**
 * Created by swathi on 6/26/16.
 */
public class ThreadSafeQueue<T> {
    private Node<T> head, tail;
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

    public synchronized void enqueue(T val) {
        Node<T> node = new Node(val);
        if (head != null) {
            tail.next = node;
            tail = node;
        } else {
            head = tail = node;
        }
        System.out.println("Value Added:" + val);
        //System.out.println("Head =" + head);
    }

    public synchronized T dequeue() {
        Node<T> valueToRemove = head;
        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = head;
            }
            System.out.println("Value Removed:" + valueToRemove.value);
            return valueToRemove.value;
        }
        System.out.println("Nothing to dequeue");
        return null;
    }
}
