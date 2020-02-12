package com.spiderman.basis._array;

import java.util.*;

public class ArrayTest {
    public static void main(String[] args) {
        String test="test";
        Set<String> stringSet=new TreeSet<>();
        stringSet.add(test);
        stringSet.add(test);
        System.out.println("stringSet:"+stringSet.size());
        Iterator<String> itr = stringSet.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        List<String> list=new ArrayList<>();
        list.add(test);
        list.add(test);
        System.out.println("list:"+list.size());
        list.forEach(s -> System.out.println(s));
    }
}

class FailFastTest{
    public static void main(String[] args) {
        forRemove();
        itorRemove();
    }
    private static void forRemove() {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
        list.forEach(i->{
            if(i.equals("3")){
               list.remove(i);
            }
        });
    }
    private static void itorRemove() {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0 ;
        while(iterator.hasNext()) {
            if (i == 3) {
                iterator.remove(); //迭代器的remove()方法
            }
            System.out.println(iterator.next());
            i ++;
        }
    }
}