package com.spiderman.juc.basics;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue {
    Queue<String> buffer = new LinkedList<String>();

    public void put(String data) {
        buffer.add(data);
        synchronized (this) {
            System.out.println("give get lock");
            notify();  // Since someone may be waiting in take
        }
    }

    public synchronized String take() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("take wait Release lock");
            //调用wait，阻塞并释放锁
            wait();
        }
        System.out.println("notify");
        buffer.forEach(tt -> {
            System.out.println("value:" + tt);
        });
        return buffer.remove();
    }


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue();
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            blockingQueue.put("a");
        }).start();

        blockingQueue.take();

    }
}


