package com.spiderman.lock.sync;


public class SynchronizedDemo implements Runnable {
    private static Integer count = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++)
                count++;
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(synchronizedDemo);
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }
}