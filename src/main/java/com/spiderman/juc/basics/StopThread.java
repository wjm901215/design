package com.spiderman.juc.basics;

/**
 * 在 StopThread 类的 run() 方法中，首先判断线程是否被中断，然后判断 count 值是否小于 1000。
 * 这个线程的工作内容很简单，就是打印 0~999 的数字，每打印一个数字 count 值加 1，
 * 可以看到，线程会在每次循环开始之前，检查是否被中断了。
 * 接下来在 main 函数中会启动该线程，然后休眠 5 毫秒后立刻中断线程，该线程会检测到中断信号，于是在还没打印完1000个数的时候就会停下来，这种就属于通过 interrupt 正确停止线程的情况。
 */
public class StopThread {

    static class StopInterruptedThread implements Runnable {
        @Override
        public void run() {
            int count = 0;
            boolean isInterrupted = false;
            while (!(isInterrupted = Thread.currentThread().isInterrupted()) && (count < 1000)) {
                System.out.println("count = " + count++);
            }
            System.out.println(isInterrupted);
        }
    }

    static class StopSleepThread implements Runnable {
        @Override
        public void run() {
            int count = 0;
            try {
                while (count < 1000) {
                    System.out.println("count = " + count++);
                    //处于休眠中的线程被中断，那么线程是可以感受到中断信号的，并且会抛出一个 InterruptedException 异常,同时清除中断信号，将中断标记位设置成 false
                    Thread.sleep(100000);
                }
            } catch (InterruptedException e) {
                System.out.println("线程中断信号");
                //线程在休眠期间被中断，那么会自动清除中断信号。如果这时手动添加中断信号，中断信号依然可以被捕捉到
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new StopInterruptedThread());
//        thread.start();
//        Thread.sleep(5);
//        thread.interrupt();

        Thread thread1 = new Thread(new StopSleepThread());
        thread1.start();
        Thread.sleep(5);
        thread1.interrupt();
    }
}
