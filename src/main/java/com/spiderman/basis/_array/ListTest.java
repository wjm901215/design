package com.spiderman.basis._array;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类操作
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.basis._array.ListTest,v 0.1 2020-06-20 16:43 Exp $$
 */
public class ListTest {
    public static void main(String[] args) {
//        unsfaeList();
//        unsfaeSet();
        unsfaeHashMap();

    }

    private static void unsfaeList() {
        //        List<String> list = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    private static void unsfaeSet() {
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set =new CopyOnWriteArraySet<>();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void unsfaeHashMap() {
//        Map<String,String> hashMap = new HashMap<>();
//        Map<String,String> hashMap = Collections.synchronizedMap(new HashMap<>());
        Map<String,String> hashMap =new ConcurrentHashMap<>();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                String substring = UUID.randomUUID().toString().substring(0, 5);
                hashMap.put(substring,"1");
                System.out.println(hashMap);
            }, String.valueOf(i)).start();
        }
    }
}
