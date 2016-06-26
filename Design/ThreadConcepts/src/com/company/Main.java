package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        synchronizeExample();
        System.out.println();
        deadLockExample();
    }

    public static void synchronizeExample(){
        withOutUsingSynchronized();
        NoSyncronizedAndAtomicVariable();
        UsingSynchronizedMethod();
        UsingSynchronizedBlock();

        //In our first SheepManager sample output, the same value, 2, was printed twice, with the highest counter being 9 instead of 10.
        //OutPut:
        /*
        No Decorators
        1 1 2 3 4 5 6 7 8 9

        No Syncronized And Atomic Variable
        2 1 3 4 5 6 7 8 9 10

        Using Synchronized Method
        1 2 3 4 5 6 7 8 9 10

        Using Synchronized Block
        1 2 3 4 5 6 7 8 9 10

         */

        /*
        Can you explain this output?
        1 3 2 4 5 6 7 8  Hi 9 10 =>
        first function runs and context switches to system thread (main) and prints hi and then the rest of first function user thread runs

        1 2 3 4 5 6 7 8 =>
        second function runs and then a context switch happens to user thread and the third functions "System.out.println() runs

        9 10 1 2 3 4 5 6 7 8 9 10 =>
        context switch happens to user thread 2nd function and it completes printing 9 and 10. now the context switches to the remaining thread (third function) and rest runs
         */
    }

    public static void deadLockExample() {
        Fox foxy = new Fox();
        Fox tails = new Fox();
        Fox.Food food = new Fox().new Food();
        Fox.Water water = new Fox().new Water();
        // Process data
        ExecutorService service = null; try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food,water));
            service.submit(() -> tails.drinkAndEat(food,water));
        } finally {
            if(service != null) service.shutdown();
        }
    }

    public static void withOutUsingSynchronized() {
        System.out.println("No Decorators");
        ExecutorService service = null;
        try {

            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            //output = 2 1 3 4 5 6 7 8 9 10
            for (int i = 0; i < 10; i++) {
                //this can be done too. And you DONT have to implement Runnable for SheepManager in this case.
                // service.submit(() -> manager.incrementAndReport());
                service.submit(manager);
            }

            // the hi can be printed anytime.
            // as there are two threads a system thread and user thread.
            //For ex: 2 1 3 4 5 6 7 8 9  Hi 10
            //System.out.print(" Hi ");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    public static void UsingSynchronizedMethod() {
        System.out.println("Using Synchronized Method");
        ExecutorService service = null;
        try {

            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReportSyncMethod());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    public static void UsingSynchronizedBlock() {
        System.out.println("Using Synchronized Block");
        ExecutorService service = null;
        try {

            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();

            for (int i = 0; i < 10; i++) {
                //synchronized(manager) { <= this wont work as you have only syncromized creation of threads and not the execution.
                //each thread would be created one at a time, but they may all still execute and perform their work at the same time
                service.submit(() -> manager.incrementAndReportSyncBlock());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    public static void NoSyncronizedAndAtomicVariable() {
        System.out.println("No Syncronized And Atomic Variable");
        ExecutorService service = null;
        try {

            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();

            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReportAtomicInteger());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
