package com.spiderman.juc.jmm;

/**
 * 加了vlatile 原子性问题？？
 *
 */
public class Visibility {

     int x = 0;

    public void write() {
        x = 1;
    }

    public void read() {
        int y=x;
        System.out.println("y:" + y);
    }


    public static void main(String[] args) {
        while (true) {
            Visibility problem = new Visibility();
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                problem.write();
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                problem.read();
            }).start();
        }
    }
}
