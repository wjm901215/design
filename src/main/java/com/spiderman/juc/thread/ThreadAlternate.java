package com.spiderman.juc.thread;

/**
 * 线程交替执行
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.juc.thread.ThreadAlternate,v 0.1 2020-06-20 13:44 Exp $$
 */
public class ThreadAlternate {
    public static void main(String[] args) {
        Num num = new Num();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    num.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程A").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    num.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    num.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程C").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    num.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程D").start();
    }

    static class Num {
        int num = 0;

        public synchronized void increment() throws InterruptedException {
            while (num == 1) {
                //等待
                this.wait();
            }
            num++;
            System.out.printf("【%s】num:%d ",Thread.currentThread().getName(),num);
            System.out.println();
            //唤醒decrement
            this.notifyAll();
        }

        public synchronized void decrement() throws InterruptedException {
            while (num == 0) {
                //等待
                this.wait();
            }
            num--;
            System.out.printf("【%s】num:%d ",Thread.currentThread().getName(),num);
            System.out.println();
            //唤醒increment
            this.notifyAll();
        }
    }
}
