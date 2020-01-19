package com.spiderman.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程不安全示例
 */
public class ThreadSafeSample {
    public int sharedState;
    public int sharedState1;
    ReentrantLock reentrantLock = new ReentrantLock(true);

    public void nonSafeAction() {
        while (sharedState < 10000) {
            reentrantLock.lock();
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " +
                        former + ", " + "latter is " + latter);
            }
            this.nonSafeAction1();
            reentrantLock.unlock();
        }
    }

    public void nonSafeAction1() {
        reentrantLock.lock();
        while (sharedState1 < 10000) {
            int former = sharedState1++;
            int latter = sharedState1;
            if (former != latter - 1) {
                System.out.println();
                System.out.printf("----Observed data race, former is " +
                        former + ", " + "latter is " + latter);
            }
        }
        reentrantLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSample sample = new ThreadSafeSample();
        Thread threadA = new Thread(() -> sample.nonSafeAction());
        Thread threadB = new Thread(() -> sample.nonSafeAction());

        Thread threadC = new Thread(() -> sample.nonSafeAction1());
        Thread threadD = new Thread(() -> sample.nonSafeAction1());
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadA.join();
        threadB.join();
        threadC.join();
        threadD.join();
    }
}