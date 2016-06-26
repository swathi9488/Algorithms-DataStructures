package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Output: (No Synchronized)
    Nothing to dequeue
    Value Added:1
    Value Added:2
    Value Added:3
    Value Added:4
    Value Added:5
    Value Removed:2
    Value Removed:3
    Value Removed:4
    Value Removed:5
    Nothing to dequeue
    Nothing to dequeue
 */

/*
Output:  (With Synchronized)
    Nothing to dequeue
    Value Added:1
    Value Added:2
    Value Added:3
    Value Added:4
    Value Added:5
    Value Removed:1
    Value Removed:2
    Value Removed:3
    Value Removed:4
    Value Removed:5
    Nothing to dequeue
 */

public class Main {
    public static void main(String[] args) {
        // write your code here
        ExecutorService service = Executors.newFixedThreadPool(20);
        ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>();
        try {
            service.submit(() -> queue.dequeue());
            service.submit(() -> queue.enqueue(1));
            service.submit(() -> queue.enqueue(2));
            service.submit(() -> queue.enqueue(3));
            service.submit(() -> queue.enqueue(4));
            service.submit(() -> queue.enqueue(5));
            service.submit(() -> queue.dequeue());
            service.submit(() -> queue.dequeue());
            service.submit(() -> queue.dequeue());
            service.submit(() -> queue.dequeue());
            service.submit(() -> queue.dequeue());
            service.submit(() -> queue.dequeue());
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
