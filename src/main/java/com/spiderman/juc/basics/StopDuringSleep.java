package com.spiderman.juc.basics;

/**
 * sleep期间能否受到中断
 *
 */
public class StopDuringSleep {
 
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (!Thread.currentThread().isInterrupted() && num <= 1000) {
                    System.out.println(num);
                    num++;
                    Thread.sleep(100000);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}

