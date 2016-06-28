package com.company;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by swathi on 6/27/16.
 */
public class ReadWriteBuffer {
    private final ReentrantReadWriteLock rwLock;
    private final StringBuilder sb;
    private final Random random;

    public ReadWriteBuffer() {
        rwLock = new ReentrantReadWriteLock();
        sb = new StringBuilder();
        random = new Random();
    }

    public String read() {
        try {
            // read lock is obtained when no thread holds the write lock. So multiple reads are possible
            rwLock.readLock().lock();
            System.out.println("Read: " + sb.toString());
            return sb.toString();
        } finally {
            rwLock.readLock().unlock();
        }

    }

    public void write() {
        try {
            //Acquires the write lock if neither the read nor write lock are held by another thread. Write is mutually exclusive.
            rwLock.writeLock().lock();
            sb.append((char) (random.nextInt(26) + 'a'));
            System.out.println("Write:" + sb.toString());
        } finally {
            rwLock.writeLock().unlock();
        }

    }
}
