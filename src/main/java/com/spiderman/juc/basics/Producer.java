package com.spiderman.juc.basics;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * volatile 修饰标记位不适用的场景
 */
class Producer implements Runnable {
    public volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
//            boolean isInterrupted=false;
            while (num <= 100000 && !canceled) {
                if (num % 50 == 0) {
                    storage.put(num);
                    System.out.println(num + "是50的倍数,被放到仓库中了。");
                }
                num++;
            }
//            System.out.println(isInterrupted);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者结束运行");
        }
    }
}


class Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    /**
     * 判断是否需要继续使用更多的数字，刚才生产者生产了一些 50 的倍数供消费者使用，
     * 消费者是否继续使用数字的判断条件是产生一个随机数并与 0.97 进行比较，大于 0.97 就不再继续使用数字
     * @return
     */
    public boolean needMoreNums() {
        if (Math.random() > 0.97) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(8);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(500);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了。");

        //一旦消费不需要更多数据了，我们应该让生产者也停下来，但是实际情况却停不下来
        // 因为在这种情况下，生产者在执行 storage.put(num) 时发生阻塞，
        // 在它被叫醒之前是没有办法进入下一次循环判断 canceled 的值的，所以在这种情况下用 volatile 是没有办法让生产者停下来的
//        producerThread.interrupt();
//        System.out.println(producerThread.isInterrupted());
        producer.canceled = true;
        System.out.println(producer.canceled);
    }
}

