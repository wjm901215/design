package com.spiderman.basis.thread;

import java.util.concurrent.TimeUnit;

/**
 * wait简单测试
 * <p>wait方法的使用必须在同步的范围内，否则就会抛出IllegalMonitorStateException异常，
 * wait方法的作用就是阻塞当前线程等待notify/notifyAll方法的唤醒，或等待超时后自动唤醒</p>
 *
 * @author Spiderman
 * @version 1.0.0: com.spiderman.basis.juc.WaitDemo,v 0.1 2019-12-27 15:41 Exp $$
 */
public class WaitDemo {

    /**
     * 线程阻塞，会释放锁，需要配合synchronized来使用
     * wait方法是一个本地方法，其底层是通过一个叫做监视器锁的对象来完成的
     * 如果不增加synchronized则在调用wait方式时就无法获取到monitor对象的所有权
     */
    public synchronized void testWait() {
        System.out.println("Start-----"+Thread.currentThread().getName());
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------"+Thread.currentThread().getName());
    }

    /**
     * 线程休眠，不会释放锁
     */
    public synchronized void testSleep() {
        System.out.println("Start-----"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        final WaitDemo waitTest = new WaitDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> waitTest.testWait()).start();
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println("--------执行分割线--------");
        final WaitDemo sleepTest = new WaitDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> sleepTest.testSleep(),"Spider"+i).start();
        }
    }
}
