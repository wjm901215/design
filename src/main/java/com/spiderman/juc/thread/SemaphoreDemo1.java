package com.spiderman.juc.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreDemo1 {


    static Semaphore semaphore = new Semaphore(3);


    static final RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.DiscardOldestPolicy();
    static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(1000);

    public static void main(String[] args) {
        DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory();
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, workQueue, defaultThreadFactory, HANDLER);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Task());
        }
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            System.out.println("1---CorePoolSize---"+threadPoolExecutor.getCorePoolSize());
        }
        executorService.shutdown();
        while (workQueue.size()>0){
            if(workQueue.size()>100) {
                if (executorService instanceof ThreadPoolExecutor) {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    threadPoolExecutor.setCorePoolSize(100);
//                    executorService=threadPoolExecutor;
                    System.out.println("setCorePoolSize(100)");
                }
            }
            System.out.println("关闭了服务器,还有未处理的信息条数：" + workQueue.size());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            System.out.println("2---CorePoolSize---"+threadPoolExecutor.getCorePoolSize());
        }

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了许可证，花费3秒执行慢服务");

            try {
                //模拟慢服务
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("慢服务执行完毕，" + Thread.currentThread().getName() + "释放了许可证");
            semaphore.release(1);
        }
    }

    /**
     * The default thread factory
     */
    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "SemaphoreDemo1-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}