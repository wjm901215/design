package com.spiderman.dataststructure.week1;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.Brackets,v 0.1 3/6/21 5:24 PM Exp $$
 */
public class Brackets {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>(6){{
            put('(',')');
            put('{','}');
            put('[',']');
        }};
        Deque<Character> stack =new LinkedList();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            }else if(stack.isEmpty() || !stack.pop().equals(c)){
                return false;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s= "()[]{}";
        boolean flag = new Brackets().isValid(s);
        System.out.println(flag);
    }
}
