package com.spiderman.thread;

import java.util.concurrent.TimeUnit;

/**
 * notify使用
 * <p>notify 针对于同一个对象，可以唤醒对应对象monitor上等待的线程，如果是多个则只能唤醒其中给一个</p>
 * <p>notifyAll 针对于同一个对象，可以唤醒对应对象monitor上等待的所有线程</p>
 *
 * @author Spiderman
 * @version 1.0.0: com.spiderman.thread.WaitNotifyDemo,v 0.1 2019-12-27 15:52 Exp $$
 */
public class WaitNotifyDemo {
    public synchronized void testWait(){
        System.out.println("Start-----"+Thread.currentThread().getName());
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final WaitNotifyDemo waitNotifyDemo=new WaitNotifyDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                waitNotifyDemo.testWait();
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
            synchronized (waitNotifyDemo) {
                System.out.println("-----notify-------");
                waitNotifyDemo.notify();
            }
            TimeUnit.SECONDS.sleep(2);
            synchronized (waitNotifyDemo) {
                System.out.println("------notifyAll-----");
                waitNotifyDemo.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
