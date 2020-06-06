package com.spiderman.juc.lock;

public class ReentrantTest {


    public static void main(String[] args) {
        MyReent reent = new MyReent();
        new Thread(reent).start();
    }

}

class MyReent implements Runnable {


    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " run");
        function();
    }


    public synchronized void function() {
        System.out.println(Thread.currentThread().getName() + " function");
    }
}