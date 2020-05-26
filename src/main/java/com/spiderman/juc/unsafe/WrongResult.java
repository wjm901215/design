package com.spiderman.juc.unsafe;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WrongResult {

    volatile static int i;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable r = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();

            }
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        };
        executorService.execute(r);

        Runnable r1 = () -> {
            for (int j = 10000; j < 20000; j++) {
                i++;
            }
        };
        System.out.println("线程ShutDown状态："+executorService.isShutdown());
        executorService.shutdown();//一定要调用这个方法，不然executorService.isTerminated()永远不为true
//        System.out.println(runnables.size());
        System.out.println("线程ShutDown状态："+executorService.isShutdown());
//        boolean b = executorService.awaitTermination(2, TimeUnit.SECONDS);
//        System.out.println("awaitTermination"+b);
        while (executorService.isShutdown()){
            System.out.println("线程是否终止："+executorService.isTerminated());
            if (executorService.isTerminated()) {
                System.out.println(i);
                break;
            }
            Thread.sleep(100);
        }
//        executorService.execute(r1);


    }
}

