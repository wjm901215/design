package com.spiderman.dataststructure.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week3.ClimbStairs,v 0.1 2/19/21 10:42 PM Exp $$
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return _recur(n, map);
    }

    private int _recur(int n, Map<Integer, Integer> map) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        System.out.println("当前执行_recur("+n+"-1) = " + (n-1) +" + _recur("+n+"-2) = " + (n-2));
        int result = _recur(n - 1, map) + _recur(n - 2, map);
        map.put(n, result);
        return result;
    }




    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();

        System.out.println(climbStairs.climbStairs(5));


    }
}
