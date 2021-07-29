package com.spiderman.dataststructure.week5;

/**
 * 爬楼梯
 * 每次只能走1/2/3步
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week5.ClimbStairs,v 0.1 3/15/21 9:40 PM Exp $$
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int[] mem = new int[100];
        return fib(n, mem);
    }

    private int fib(int n, int[] mem) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        if (mem[n] == 0) {
            mem[n] = fib(n - 1, mem) + fib(n - 2, mem) + fib(n - 3, mem);
        }
        return mem[n];
    }

    /**
     * n = 0, {0}
     * n = 1 , {1}
     * n = 2 , {11,2}
     * n = 3, { 111,12, 21, 3}
     * n = 4, { 1111, 112,121,13,211,22, 31}
     *
     * @param args
     */
    public static void main(String[] args) {
        ClimbStairs recursionNumbers = new ClimbStairs();
//        System.out.println(recursionNumbers.factorialNum(10));
//        System.out.println(recursionNumbers.climbStairs(5));



    }
}
