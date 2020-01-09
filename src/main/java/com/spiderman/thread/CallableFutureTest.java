package com.spiderman.thread;// Java program to illustrate Callable and FutureTask
// for random number generation 

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class CallableExample implements Callable {

    int i;

    public CallableExample(int i) {
        this.i = i;
    }

    public Object call() throws Exception {
        System.out.println("------"+i+"--------");
        Integer randomNumber=3;
        Thread.sleep(randomNumber * 1000);

        return i;
    }

}

public class CallableFutureTest {
    public static void main(String[] args) throws Exception {

        FutureTask[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++) {
            Callable callable = new CallableExample(i);
            randomNumberTasks[i] = new FutureTask(callable);
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(randomNumberTasks[i].get());

        }
    }
}


class CallableFutureExecutorServiceTest {
    public static void main(String[] args) throws Exception {

        List<Future> list=new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Callable callable = new CallableExample(i);
            Future future = executorService.submit(callable);
            list.add(future);

        }
        list.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}

