package com.spiderman.juc.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替顺序执行
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.juc.thread.ThreadAlternate,v 0.1 2020-06-20 13:44 Exp $$
 */
public class ThreadLockAlternate {
    public static void main(String[] args) {
        Num num = new Num();

        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    num.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    num.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程B").start();

        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    num.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程C").start();
    }

    static class Num {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        int num = 1;

        public void printA() throws InterruptedException {
            try {
                lock.lock();
                while (num != 1) {
                    //等待
                    conditionA.await();
                }
                System.out.printf("【%s】执行:%s ", Thread.currentThread().getName(), "A");
                System.out.println();
                //唤醒decrement
                num = 2;
                conditionB.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void printB() throws InterruptedException {
            try {
                lock.lock();
                while (num != 2) {
                    //等待
                    conditionB.await();
                }
                System.out.printf("【%s】执行:%s ", Thread.currentThread().getName(), "B");
                System.out.println();
                //唤醒decrement
                num = 3;
                conditionC.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void printC() throws InterruptedException {
            try {
                lock.lock();
                while (num != 3) {
                    //等待
                    conditionC.await();
                }
                System.out.printf("【%s】执行:%s ", Thread.currentThread().getName(), "C");
                System.out.println();
                //唤醒decrement
                num = 1;
                conditionA.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
