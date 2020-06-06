package com.spiderman.juc.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(6);
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("三人行必有我师");
        });
        for (int i = 0; i < 6; i++) {
            executorService.submit(new Task(i + 1, cyclicBarrier));
        }
        executorService.shutdown();
    }

    static class Task implements Runnable {

        private int id;
        private CyclicBarrier cyclicBarrier;

        public Task(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("同学" + id + "现在从大门出发，前往自行车驿站");
            try {
                long time= (long) (Math.random() * 10000);
                Thread.sleep(time);
                System.out.println("同学" + id + "到了自行车驿站，开始等待其他人到达，花了"+time+"ms");
                cyclicBarrier.await();
                System.out.println("同学" + id + "开始骑车");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}