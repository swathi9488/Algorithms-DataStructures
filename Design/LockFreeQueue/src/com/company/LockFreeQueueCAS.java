package com.company;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by swathi on 6/26/16.
 */
public class LockFreeQueueCAS<T> {
    private class Node<T> {
        final T value;
        final AtomicReference<Node<T>> next;

        public Node(T val, Node<T> next) {
            this.value = val;
            this.next = new AtomicReference<>(next);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
    private AtomicReference<Node<T>> head, tail;

    public LockFreeQueueCAS() {
        Node<T> placeHolder = new Node(null, null);

        // add a placeHolder node because avoid nulls on
        // atomic refernces and so that you dont have to compare nulls later
        head = new AtomicReference<>(placeHolder);
        tail = new AtomicReference<>(placeHolder);
    }

    // Uses a more complex enqueue process
    public boolean enqueue(T val) {
        Node<T> newNode = new Node<T>(val, null);
        while (true) {
            Node<T> curTail = tail.get();
            Node<T> residue = curTail.next.get();
            if (curTail == tail.get()) {
                if (residue == null) /* A */ {
                    if (curTail.next.compareAndSet(null, newNode)) /* C */ {
                        tail.compareAndSet(curTail, newNode) /* D */ ;
                        System.out.println("Item Added:" + val);
                        return true;
                    }
                } else {
                    tail.compareAndSet(curTail, residue) /* B */;
                }
            }
        }
    }

    public T dequeue() {
        Node<T> headNode;
        Node<T> nextNode;
        // by this logic the head placeholder will always remain
        do {
            headNode = head.get();
            nextNode = headNode.next.get();
            if (nextNode == null) {
                System.out.println("Nothing to dequeue");
                return null;
            }
            // the while ensures that if some other thread tried changing the head in the interim, then restart the process
        } while (!head.compareAndSet(headNode, nextNode));

        T removedElement = nextNode.value;

        // avoid memory leak
        nextNode = new Node<>(null, null);
        System.out.println("Item Removed:" + removedElement);
        return removedElement;
    }
}

