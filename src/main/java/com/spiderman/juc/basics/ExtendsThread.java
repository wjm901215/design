package com.spiderman.juc.basics;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0: com.spiderman.juc.basics.RunnableThread,v 0.1 2020-05-21 18:24 Exp $$
 */
public class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }

    public static void main(String[] args) {
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();

    }

}


