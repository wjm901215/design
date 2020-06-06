package com.spiderman.juc.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 描述：     在16个线程下使用AtomicLong
 */
public class AtomicLongDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong atomicCount = new AtomicLong(0);
        LongAdder counter = new LongAdder();
        final Integer[] it = {0};
        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            service.submit(()->{
                atomicCount.incrementAndGet();
                counter.increment();
                it[0]++;
            });
        }

        Thread.sleep(2000);
        System.out.println(it[0]);
        System.out.println(atomicCount.get());
        System.out.println(counter.sum());
        service.shutdown();
    }

}

