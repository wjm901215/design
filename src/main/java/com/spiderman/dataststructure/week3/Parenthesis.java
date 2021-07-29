package com.spiderman.dataststructure.week3;

import java.util.*;

/**
 * 22. 括号生成
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week3.Parenthesis,v 0.1 2/18/21 8:43 PM Exp $$
 */
public class Parenthesis {
    List<String> result  = new ArrayList<>();



    public List<String> generateParenthesis(int n) {
//        _generate(0,0,n,"");
        _generate(0,2 * n,"");
        return result;
    }

    /**
     * 递归函数
     * @param left 左括号层级
     * @param right 右括号层级
     * @param n 括号个数
     * @param s 结果
     */
    private void _generate(int left, int right, int n, String s) {
        // 终止条件
        if (left >= n && right >= n) {
            result.add(s);
            return;
        }
        // 处理逻辑

        // 下钻，调用递归
        if (left < n) {
            _generate(left + 1, right, n , s + "(");
        }
        if (right < n && left> right) {
            _generate(left,right+1, n, s + ")");
        }
        // 恢复当前状态
    }

    /**
     * 递归函数，所有组合
     * @param level 层级
     * @param max 最大深度
     * @param s
     */
    private void _generate(int level, int max, String s) {
        // 终止条件
        if (level >= max) {
            System.out.println(s);
            return;
        }
        // 处理逻辑
        String s1 = s + "(";
        String s2 = s + ")";

        // 下钻，调用递归
        _generate(level + 1,max,s1);
        _generate(level + 1,max,s2);
        // 恢复当前状态
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
//        List<String> result  = parenthesis.generateParenthesis(3);
//        result.stream().forEach(s -> System.out.println(s));


//        parenthesis.generateParenthesis(2);

        String test = ")()))))";
        char[] chars = test.toCharArray();
        System.out.println(parenthesis.valid(chars));

    }

    public boolean valid(char[] current) {
        char left = '(',right =  ')';
        Deque<Character> queue = new LinkedList<>();

        for (char c: current) {
            if(c == left) {
                queue.add(c);
            }else if(c == right) {
                queue.poll();
            }
        }
        return queue.size() == 0;
    }
}
