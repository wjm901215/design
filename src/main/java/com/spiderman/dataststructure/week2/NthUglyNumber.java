package com.spiderman.dataststructure.week2;

import java.util.*;

/**
 * 丑数​
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.MoveZero,v 0.1 1/29/21 6:16 PM Exp $$
 */
public class NthUglyNumber {
    private int[] uglyNumber = {2, 3, 5};

    /**
     * 利用小根堆，然后1作为第一个丑数，每次从小根堆弹出最小的丑数，
     * 然后记录已弹出丑数的个数，如果count>=n,返回当前弹出的元素，否则继续乘以2、3、5
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] defaultNums = {2, 3, 5};
        //小顶堆思想
        Queue<Integer> queue = new PriorityQueue<>();
        //主要用与新丑数去重复
        HashSet<Integer> hashset = new HashSet<>();
        queue.offer(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int res = queue.poll();
            if (++count >= n) {
                return res;
            }
            for (int num :defaultNums) {
                int newUglyNum = res * num;
                // 判断去重复
                if(!hashset.contains(newUglyNum)){
                    queue.offer(newUglyNum);
                    hashset.add(newUglyNum);
                }
            }
        }
        return -1;
    }
//    public int nthUglyNumber(int n) {
//        //创建小根堆，每次出堆的都是最小值
//        Queue<Long> queue = new PriorityQueue<>();
//        queue.add(1L);
//        //记录出堆的个数，出堆的元素完全按照从小到大排序
//        int count = 0;
//        while (!queue.isEmpty()) {
//            long cut = queue.poll();
//
//            //如果出堆的个数>=n,当前cut就是第n个丑数
//            if (++count >= n) {
//                return (int) cut;
//            }
//            for (int num : uglyNumber) {
//                //排除重复的数字
//                if (!queue.contains(num * cut)) {
//                    queue.add(num * cut);
//                }
//            }
//        }
//        return -1;
//    }

    public int nthUglyNumberSlow(int n) {
        List<Integer> res = new ArrayList();
        int i = 1;
        while (res.size() < n) {
            if (isUgly(i)) {
                res.add(i);
            }
            i++;
        }
        return res.get(n - 1);
    }

    /**
     * 判断一个数是否只有2，3，5因子（丑数）
     *
     * @param num 待判断的数，非负
     * @return true是丑数，false丑数
     */
    private static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }


    /**
     * 解法3:采用动态规划方式
     * 定义3个指针，分别从下标 0开始，针对3个质因子【2、3、5】分别计算新从丑数，然后取最小数
     * 依次遍历，直到为n，返回结果
     */
    public int nthUglyNumberFast(int n) {
        int a = 0, b = 0, c = 0;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; ++i) {
            int temp1 = result[a] * 2;
            int temp2 = result[b] * 3;
            int temp3 = result[c] * 5;
            int temp = Math.min(Math.min(temp1, temp2), temp3);
            result[i] = temp;
            if (temp == temp1) a++;
            if (temp == temp2) b++;
            if (temp == temp3) c++;
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        NthUglyNumber solution = new NthUglyNumber();
        System.out.println(solution.nthUglyNumber(11));
    }
}
