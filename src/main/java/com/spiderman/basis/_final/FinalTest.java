package com.spiderman.basis._final;

import java.util.*;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author Spiderman
 * @version 1.0: com.spiderman.basis._final.FinalTest,v 0.1 2020-01-12 12:51 Exp $$
 */
public class FinalTest {

    public static void main(String[] args) {
        final List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("world");
        strList.forEach(s -> System.out.println(s));
        List strList1 = Arrays.asList(1,2,3);
        strList1.set(0,5);
        strList1.forEach(s -> System.out.println(s));
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());


    }
}
