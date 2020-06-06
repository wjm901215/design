package com.spiderman.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.juc.atomic.VolatileTest,v 0.1 2020-05-30 11:04 Exp $$
 */
public class VolatileTest implements Runnable {
    static int count = 0;
    static AtomicInteger counter=new AtomicInteger();
    volatile static boolean flag = true;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            synchronized (this) {
                count++;
            }
            counter.getAndIncrement();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Runnable volatileTest = new VolatileTest();
        Thread thread = new Thread(volatileTest);
        thread.start();
        Thread thread1 = new Thread(volatileTest);
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(count);
        System.out.println(counter.get());
    }
}
