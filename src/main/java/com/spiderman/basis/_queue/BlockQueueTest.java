package com.spiderman.basis._queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.basis._queue.BlockQueueTest,v 0.1 2020-06-22 11:04 Exp $$
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
//        new BlockQueueTest().methodException();
//        new BlockQueueTest().methodNoException();
//        new BlockQueueTest().methodBlock();
        new BlockQueueTest().methodTimeBlock();
    }

    /**
     * 方式一，抛异常
     */
    public void methodException() {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        //java.lang.IllegalStateException: Queue full
//        System.out.println(arrayBlockingQueue.add("d"));
        System.out.println("==============================");
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        // java.util.NoSuchElementException
        System.out.println(arrayBlockingQueue.remove());
    }

    /**
     * 方式二，不抛异常
     */
    public void methodNoException() {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        //java.lang.IllegalStateException: Queue full
        System.out.println(arrayBlockingQueue.offer("d"));
        System.out.println("==============================");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // java.util.NoSuchElementException
        System.out.println(arrayBlockingQueue.poll());
    }


    /**
     * 方式三，阻塞队列
     */
    public void methodBlock() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        System.out.println("==============================");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
    }

    /**
     * 方式四，超时等待
     */
    public void methodTimeBlock() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("a", 2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("b", 2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("c", 2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("d", 2, TimeUnit.SECONDS);
        System.out.println("==============================");
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
    }
}
