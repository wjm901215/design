package com.spiderman.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWSample {
    private final Map<String, String> m = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public String get(String threadName,String key) {
        r.lock();
        System.out.println("读锁线程名称"+threadName);
        System.out.println("读锁锁定！");
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    public String put(String threadName,String key, String entry) {
        w.lock();
        System.out.println("写锁线程名称"+threadName);
        System.out.println("写锁锁定！");
        try {
            return m.put(key, entry);
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RWSample rwSample = new RWSample();
        for (int i = 0; i < 10; i++) {
            String key = "key" + i;
            String value = "value" + i;
            Thread thread = new Thread(() -> {
                rwSample.put(Thread.currentThread().getName(),key, value);
            });
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            String key = "key" + i;
            Thread thread = new Thread(() -> {
                System.out.println(rwSample.get(Thread.currentThread().getName(),key));
            });
            thread.start();
        }
        Thread.sleep(5000);
    }

}
