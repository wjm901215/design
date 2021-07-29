package com.spiderman.dataststructure.week5;

/**
 * 递归测试
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week3.test.RecursionNumbers,v 0.1 3/9/21 8:48 PM Exp $$
 */
public class RecursionNumbers {
    /**
     * N的阶乘
     *
     * @param n
     * @return
     */
    public int factorialNum(int n) {
        return n <= 1 ? n : n * factorialNum(n - 1);
    }

    /**
     * 斐波拉契数据
     * 缓存方式
     * 自顶向下方式
     *
     * @param n
     * @param mem
     * @return
     */
    public int fib(int n, int[] mem) {
        if (n <= 1) {
            return n;
        }
        if (mem[n] == 0) {
            mem[n] = fib(n - 1, mem) + fib(n - 2, mem);
        }
        return mem[n];
    }

    /**
     * 斐波拉契数据,循环方式 自底向上
     * 1,1,2,3,5,8,
     *
     * @param n
     * @return
     */
    public int fibloop(int n) {
        int[] result = new int[n + 2];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }


    public static void main(String[] args) {
        RecursionNumbers recursionNumbers = new RecursionNumbers();
//        System.out.println(recursionNumbers.factorialNum(10));
        int[] mem = new int[101];
        System.out.println(recursionNumbers.fib(20, mem));
        System.out.println(recursionNumbers.fibloop(20));
    }
}
