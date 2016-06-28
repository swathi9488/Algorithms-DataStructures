package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ReadWriteBuffer buffer = new ReadWriteBuffer();
        ExecutorService service = Executors.newFixedThreadPool(20);
        //LockFreeQueueCAS<Integer> queue = new LockFreeQueueCAS<>();
        try {
            service.submit(() -> buffer.read());
            service.submit(() -> buffer.write());
            service.submit(() -> buffer.write());
            service.submit(() -> buffer.write());
            service.submit(() -> buffer.write());
            service.submit(() -> buffer.write());
            service.submit(() -> buffer.read());
            service.submit(() -> buffer.read());
            service.submit(() -> buffer.read());
            service.submit(() -> buffer.write());
            service.submit(() -> buffer.write());
            service.submit(() -> buffer.read());
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
