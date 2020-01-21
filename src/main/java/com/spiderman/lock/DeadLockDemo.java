package com.spiderman.lock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁示例
 * <p>开启了两个线程threadA, threadB,其中threadA占用了resource_a, 并等待被threadB释放的resource _b。</p>
 * <p>threadB占用了resource _b正在等待被threadA释放的resource _a。因此threadA,threadB出现线程安全的问题，形成死锁。同样可以通过jps,jstack证明</p>
 *
 * 如何避免死锁
 * <p>1.避免一个线程同时获得多个锁；</p>
 * <p>2.避免一个线程在锁内部占有多个资源，尽量保证每个锁只占用一个资源；</p>
 * <p>3.尝试使用定时锁，使用lock.tryLock(timeOut)，当超时等待时当前线程不会阻塞；</p>
 * <p>4.对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况</p>
 *
 * @author Spiderman
 * @version 1.0.0: com.spiderman.lock.DeadLockDemo,v 0.1 2019-12-27 11:24 Exp $$
 */
public class DeadLockDemo {
    /**
     * 资源A
     */
    private static String resource_a = "resource_a";
    /**
     * 资源B
     */
    private static String resource_b = "resource_b";

    private static final int sleep = 3;

    public static void deadLockMethod() {
        Thread threadA = new Thread(() -> {
            System.out.println("线程：" + Thread.currentThread().getName());
            synchronized (resource_a) {
                System.out.println("获取资源A数据");
                try {
                    TimeUnit.SECONDS.sleep(sleep);
                    System.out.println(String.format("threadA休眠%d秒", sleep));
                    synchronized (resource_b) {
                        System.out.println("获取资源B数据");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread threadB = new Thread(() -> {
            System.out.println("线程：" + Thread.currentThread().getName());
            synchronized (resource_b) {
                System.out.println("获取资源B数据");
                try {
                    TimeUnit.SECONDS.sleep(sleep);
                    System.out.println(String.format("threadB休眠%d秒", sleep));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource_a) {
                    System.out.println("获取资源A数据");
                }
            }

        });
        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        deadLockMethod();
    }
}
