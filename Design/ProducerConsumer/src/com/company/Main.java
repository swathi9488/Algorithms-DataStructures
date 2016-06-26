package com.company;

import java.util.concurrent.*;

//http://codereview.stackexchange.com/questions/35371/thread-safe-enqueue-and-dequeue-method-in-queue
public class Main {

    public static void main(String[] args) {
        // Case when consumption equal to production
        runProducerConsumer();

        /*
         Case: Consumption rate is less than production rate
            if I have 10 producers and 10 consumers
            producers produce 3 in one go and consumers only consume 1 in one go
            in such a case after the 10 consumers have consumed 1 each,
            The producer (enqueue) code goes into wait as there are no enough consumers
        */
        //productionMoreThanConsumption();

        /*
        Case: Consumption rate is more than production rate
            if I have 10 producers and 10 consumers
            producers produce 1 in one go and consumers only consume 3 in one go
            in such a case after the 10 producers have produced 1 each,
            The consumer (dequeue) code goes into wait as there are not enough production of items
        */
        //productionLessThanConsumption();
    }

    private static void runProducerConsumer() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>();
        try {
            for (int i = 0; i < 10; i++) {
                // Consumer
                service.submit(() -> new Producer(queue, 3).produceItems());

                // Producer
                service.submit(() -> new Consumer(queue, 3).consumeItems());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

    }

    private static void productionMoreThanConsumption() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>();
        try {
            for (int i = 0; i < 10; i++) {
                // Consumer
                service.submit(() -> new Producer(queue, 3).produceItems());

                // Producer
                service.submit(() -> new Consumer(queue, 1).consumeItems());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

    }

    private static void productionLessThanConsumption() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>();
        try {
            for (int i = 0; i < 10; i++) {
                // Consumer
                service.submit(() -> new Producer(queue, 3).produceItems());

                // Producer
                service.submit(() -> new Consumer(queue, 1).consumeItems());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

    }
}
