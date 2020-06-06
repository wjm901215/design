package com.spiderman.juc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo2 {


    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                service.submit(new Task2());
            } else {
                service.submit(new Task1());
            }
        }
        service.shutdown();
    }

    static class Task1 implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task1 "+Thread.currentThread().getName() + "拿到了许可证，花费5秒执行慢服务");

            try {
                //模拟慢服务
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task1 慢服务执行完毕，" + Thread.currentThread().getName() + "释放了许可证");
            semaphore.release(5);
        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task2 "+Thread.currentThread().getName() + "拿到了许可证，花费1秒执行慢服务");

            try {
                //模拟慢服务
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task2 慢服务执行完毕，" + Thread.currentThread().getName() + "释放了许可证");
            semaphore.release();
        }
    }
}


