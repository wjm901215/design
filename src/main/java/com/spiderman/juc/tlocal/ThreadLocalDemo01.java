package com.spiderman.juc.tlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo01 {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);
//    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    public static void main(String[] args) throws InterruptedException {

//        new Thread(() -> {
//            String date = new ThreadLocalDemo01().date(1);
//            System.out.println(date);
//        }).start();
//
//        new Thread(() -> {
//            String date = new ThreadLocalDemo01().date(2);
//            System.out.println(date);
//        }).start();

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(() -> {
                String date = new ThreadLocalDemo01().date(finalI);
                System.out.println(date);
            });
        }
        executorService.shutdown();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        return simpleDateFormat.format(date);
    }
}

class ThreadSafeFormatter {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("mm:ss");
        }
    };
}

