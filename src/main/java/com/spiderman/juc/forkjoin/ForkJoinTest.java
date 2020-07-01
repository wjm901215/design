package com.spiderman.juc.forkjoin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin测试，1-10亿累加
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0: com.spiderman.juc.forkjoin.ForkJoinTest,v 0.1 2020-06-23 21:16 Exp $$
 */
public class ForkJoinTest {

    static final Long START_NUM = 1L;
    static final Long MAX_NUM = 10_0000_0000L;
    static final Long THRESHOLD = 10000L;

    public static void main(String[] args) {
//        ForkJoinTest forkJoinTest = new ForkJoinTest();
//        forkJoinTest.ordinary();

        LocalDateTime startTime = LocalDateTime.now();
        SumTask sumTask = new SumTask(START_NUM, MAX_NUM);
        sumTask.fork();
        System.out.print("result:" + sumTask.join());
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(Duration.between(startTime, endTime).getNano() / 1000 / 1000);

    }

    /**
     * 普通方式处理
     */
    private void ordinary() {

        long sum = 0;
        for (long i = 1; i <= MAX_NUM; i++) {
            sum += i;
        }
        System.out.println("总和" + sum);

    }

    static class SumTask extends RecursiveTask<Long> {

        private Long start = 0L;
        private Long end = 0L;

        public SumTask(Long start, Long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            if (end - start < THRESHOLD) {
                //小于100时直接返回结果
                Long sumResult = 0L;
                for (Long i = start; i <= end; i++) {
                    sumResult += i;
                }
                return sumResult;
            } else {
                //大于THRELOD进行分割
                Long middle = (end + start) / 2;
                SumTask leftSum = new SumTask(this.start, middle);
                SumTask rightSum = new SumTask(middle, this.end);
                leftSum.fork();
                rightSum.fork();
                return leftSum.join() + rightSum.join();
            }
        }

    }
}
