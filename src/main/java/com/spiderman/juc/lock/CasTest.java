package com.spiderman.juc.lock;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1。0: com.spiderman.juc.lock.CasTest,v 0.1 2020-06-03 23:04 Exp $$
 */
public class CasTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        Object o=new Object();
        System.out.println(o.toString());
        concurrentLinkedQueue.offer(o);
        Object poll = concurrentLinkedQueue.poll();
        System.out.println(poll.toString());

    }
}
