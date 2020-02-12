package com.spiderman.basis.thread;


import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

public class Test {
    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public long calc() throws InterruptedException {
        final Test test = new Test();
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return test.count;
    }

    public static void main(String[] args) {
        try {
            System.out.println("count:" + new Test().calc());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
        if (v == true) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileExample test = new VolatileExample();
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> test.writer());
        Thread th2 = new Thread(() -> test.reader());
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
//        TimeUnit.SECONDS.sleep(1);
    }
}