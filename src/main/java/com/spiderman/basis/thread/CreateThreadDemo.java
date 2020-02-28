package com.spiderman.basis.thread;

import java.util.concurrent.*;

public class CreateThreadDemo {

    public static void main(String[] args) {
        //1.继承Thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("继承Thread");
                super.run();
            }
        };
        thread.start();
        //2.实现Runnable接口
        Thread thread1 = new Thread(() -> System.out.println("实现Runnable接口"));
        thread1.start();
        //3.实现Callable接口
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit((Callable) () -> "通过实现Callable接口");
        try {
            String result = future.get();
            System.out.println(result);
            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
