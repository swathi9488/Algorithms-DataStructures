package com.company;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by swathi on 6/26/16.
 */
public class LockFreeQueue<T> {
    private class Node<T> {
        final T value;
        volatile Node<T> next;

        public Node(T val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
    private AtomicReference<Node<T>> head, tail;

    public LockFreeQueue() {
        Node<T> placeHolder = new Node(null);

        // add a placeHolder node because avoid nulls on
        // atomic refernces and so that you dont have to compare nulls later
        head = new AtomicReference<>(placeHolder);
        tail = new AtomicReference<>(placeHolder);
    }

    public void enqueue(T val) {
        Node<T> newNode = new Node<>(val);
        Node<T> prevTail = tail.getAndSet(newNode);

        // prevTail.next = tail not possible as tail is an atomicReference
        prevTail.next = newNode;
        System.out.println("Item Added:" + val);
    }

    public T dequeue() {
        Node<T> headNode;
        Node<T> nextNode;
        // by this logic the head placeholder will always remain
        do {
            headNode = head.get();
            nextNode = headNode.next;
            if (nextNode == null) {
                System.out.println("Nothing to dequeue");
                return null;
            }
        // the while ensures that if some other thread tried changing the head in the interim, then restart the process
        } while (!head.compareAndSet(headNode, nextNode));

        T removedElement = nextNode.value;

        // avoid Memory leak
        nextNode = new Node<>(null);
        System.out.println("Item Removed:" + removedElement);
        return removedElement;
    }
}
