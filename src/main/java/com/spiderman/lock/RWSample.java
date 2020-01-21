package com.spiderman.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO
 */
public class RWSample {
    private final Map<String, String> m = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public String get(String threadName, String key) {
        r.lock();
        System.out.println("读锁线程名称" + threadName);
        try {
            Thread.sleep(500);
            return m.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            r.unlock();
        }
        return null;
    }

    public String put(String threadName, String key, String entry) {
        w.lock();
        System.out.println("写锁线程名称" + threadName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return m.put(key, entry);
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RWSample rwSample = new RWSample();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String key = "key" + i;
                System.out.println(rwSample.get(Thread.currentThread().getName(), key));
            }
        });
        thread1.start();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String key = "key" + i;
                String value = "value" + i;
                rwSample.put(Thread.currentThread().getName(), key, value);
            }
        });
        thread.start();


        Thread.sleep(5000);
    }

}
