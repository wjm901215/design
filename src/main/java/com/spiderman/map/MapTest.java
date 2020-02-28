package com.spiderman.map;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> result=new HashMap<>();
        result.put(1,"1");
        result.put(9,"5");
        result.put(5,"2");
        result.put(7,"3");
        result.put(4,"4");
        Set<Map.Entry<Integer, String>> entries = result.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().getKey());
        }


    }
}
