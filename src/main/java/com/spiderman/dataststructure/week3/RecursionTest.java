package com.spiderman.dataststructure.week3;

/**
 * 递归测试
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week3.RecursionTest,v 0.1 2021/5/18 15:47 Exp $$
 */
public class RecursionTest {

    int f(int n) {
        if (n == 1)
            return 1;
        return f(n-1) + 1;
    }

    public static void main(String[] args) {
        int f = new RecursionTest().f(3);
        System.out.println(f);
    }
}
