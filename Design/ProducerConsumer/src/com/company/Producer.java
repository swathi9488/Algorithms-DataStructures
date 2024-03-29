package com.company;

import java.util.Queue;

/**
 * Created by swathi on 6/26/16.
 */
public class Producer {
    private static int THREAD_DELAY = 1000;

    private BlockingQueue queue;
    private int numItemsProducedPerCall;

    public Producer(BlockingQueue queue, int numItemsProducedPerCall) {
        this.queue = queue;
        this.numItemsProducedPerCall = numItemsProducedPerCall;
    }

    public void produceItems() {
        try {
            for (int i = 0; i < numItemsProducedPerCall; i++) {
                queue.enqueue(i + 1);
                Thread.sleep(THREAD_DELAY);
            }
        } catch (InterruptedException e) {
            System.out.println("Production Interrupted");
        }

    }
}
