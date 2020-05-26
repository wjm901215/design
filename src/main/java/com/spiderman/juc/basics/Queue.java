package com.spiderman.juc.basics;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.lang.Object;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用 BlockingQueue 实现生产者消费者模式
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0: com.spiderman.juc.basics.Queue,v 0.1 2020-05-23 15:19 Exp $$
 */
public class Queue {
    public static void main(String[] args) throws InterruptedException {

//        java.util.concurrent.BlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);
        MyBlockingQueueForCondition queue = new MyBlockingQueueForCondition(10);
        Runnable producer = () -> {
//            while (true) {
                try {
                    Thread.sleep(1000);
                    queue.put(new Object());
                    System.out.println(Thread.currentThread().getId() + "消息生产");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        };

        new Thread(producer).start();
        Runnable consumer = () -> {
//            while (true) {
                try {
                    System.out.println(Thread.currentThread().getId() + "准备消息消费");
                    queue.take();
                    System.out.println(Thread.currentThread().getId() + "消息消费成功");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();
    }

}

/**
 * 自己实现一个简易版的 BlockingQueue
 */
class MyBlockingQueueForCondition {

    private LinkedList queue;
    private int max=10;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();


    public MyBlockingQueueForCondition(int size) {
        this.max = size;
        queue = new LinkedList();
    }

    public void put(Object o) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == max) {
                System.out.println("put阻塞");
                notFull.await();
            }
            queue.add(o);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            if (queue.size() == 0) {
                System.out.println("take阻塞");
                notEmpty.await();
            }
            System.out.println("release lock exec");
            Object item = queue.remove();
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }
}

