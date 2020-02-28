package com.spiderman.basis.thread;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    final static int MAX=10;
    static volatile  int initValue=0;

    public static void main(String[] args) {
        new ReadThread().start();
        new Thread(()->{
            int localValue=initValue;
            while(localValue<MAX){
                System.out.println("Writer:"+(++localValue));
                initValue=localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Writer").start();
    }

}
class ReadThread extends Thread{
    @Override
    public void run() {
        int localValue=VolatileTest.initValue;
        while(localValue<VolatileTest.MAX){
            if(localValue!=VolatileTest.initValue){
                System.out.println("Reader:"+VolatileTest.initValue);
                localValue=VolatileTest.initValue;
            }
        }
    }
}
