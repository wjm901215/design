package com.spiderman.juc.lock;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.juc.lock.MyBlockingQueueForCondition,v 0.1 2020-06-02 11:00 Exp $$
 */
public class MyBlockingQueueForCondition {

    private Queue queue;
    private int max = 10;
    private ReentrantLock lock = new ReentrantLock();

    private Condition notEmpty = lock.newCondition();

    private Condition notFull = lock.newCondition();

    public MyBlockingQueueForCondition(int size) {
        this.max = size;
        queue = new LinkedList();
    }

    /**
     * 数据放入
     *
     * @param o
     */
    private void put(Object o) {
        System.out.println("开始存放数据");
        lock.lock();
        try {
            while (this.max == queue.size()) {
                System.out.println("put  lock");
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(o);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 数据提取
     *
     * @return
     */
    private Object take() {
        System.out.println("开始提取数据");
        lock.lock();
        try {
            while (queue.size()==0){
                System.out.println("take lock");
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object item = queue.remove();
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueueForCondition myBlockingQueueForCondition = new MyBlockingQueueForCondition(10);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                Object o = new Object();
                myBlockingQueueForCondition.put(o);
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                Object o = new Object();
                myBlockingQueueForCondition.take();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

    }
}

