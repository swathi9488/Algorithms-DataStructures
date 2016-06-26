package com.company;

/**
 * Created by swathi on 6/26/16.
 */
public class Consumer {
    private static int THREAD_DELAY = 1000;

    private ThreadSafeQueue queue;
    private int numConsumedPerCall;

    public Consumer(ThreadSafeQueue queue, int numConsumedPerCall) {
        this.queue = queue;
        this.numConsumedPerCall = numConsumedPerCall;
    }

    public void consumeItems() {
        try {
            for (int i = 0; i < numConsumedPerCall; i++) {
                queue.dequeue();
                Thread.sleep(THREAD_DELAY);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumption Interrupted");
        }

    }
}
