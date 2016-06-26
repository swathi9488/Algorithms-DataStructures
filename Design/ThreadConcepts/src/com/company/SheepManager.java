package com.company;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by swathi on 6/25/16.
 */
public class SheepManager implements Runnable {
    private int sheepCount = 0;
    public AtomicInteger atmoitcSheepCount = new AtomicInteger(0);

    public void run() {
        incrementAndReport();
    }

    public void incrementAndReport() {
        System.out.print((++sheepCount) + " ");
    }

    public synchronized void incrementAndReportSyncMethod() {
        System.out.print((++sheepCount) + " ");
    }

    public void incrementAndReportSyncBlock() {
        synchronized (this) {
            System.out.print((++sheepCount) + " ");
        }
    }

    public void incrementAndReportAtomicInteger() {
        System.out.print(atmoitcSheepCount.incrementAndGet()+" ");
    }

}

