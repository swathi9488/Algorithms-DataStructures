package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//http://codereview.stackexchange.com/questions/224/thread-safe-and-lock-free-queue-implementation
/*
Output:
    Nothing to dequeue
    Item Added:1
    Item Added:2
    Item Added:3
    Item Added:4
    Item Added:5
    Item Removed:1
    Item Removed:2
    Item Removed:3
    Item Removed:4
    Item Removed:5
    Nothing to dequeue
*/
public class Main {

    public static void main(String[] args) {
	// write your code here
        ExecutorService service = Executors.newFixedThreadPool(20);
        LockFreeQueue<Integer> queue = new LockFreeQueue<>();
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
