package com.spiderman.basis._string;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author Spiderman
 * @version 1.0: com.spiderman.basis._string.StringTest,v 0.1 2020-01-13 11:35 Exp $$
 */
public class StringTest {

    public static void main(String[] args) {
        //通过直接量赋值方式，放入字符串常量池
//        String tt="abc";
//        String bb="abc";
//        //通过new方式，不放入字符串常量池
//        String cc=new String("abc");
//        System.out.println(tt.getBytes());
//        System.out.println(bb.getBytes());
//        System.out.println(cc.getBytes());
//        //指向同一个常量池
//        if(tt==bb){
//            System.out.println("tt==bb");
//        }
//        if(tt==cc){
//            System.out.println("tt==cc");
//        }else{
//            System.out.println("tt!=cc");
//        }

        _intern();
//        __intern();
//        ___intern();

    }

    /**
     * java 8
     * 1.new String创建对象实际做了两步，1创建对象，将12加入到常量池中
     * 2.intern 查找常量池中是否有12
     * 3.s4 查找常量池中是否有12
     * 4.判断两个对象地址，false
     */
    private static void __intern() {
        String s3 = new String("12");
        s3.intern();
        String s4 = "12";

        System.out.println(s3 == s4);
    }

    /**
     * java 8
     * 1.new String()实际创建了创建2个对象，将12和34分别加入到常量池中
     * 2.intern 查找常量池中是否有1234是否在常量池中，将1234加入到常量池
     * s4查找到常量池中已经存在1234，直接使用
     * 3.判断两个对象地址，true
     */
    private static void _intern() {
        String s3 = new String("12") + new String("34");
        s3.intern();
        String s4 = "1234";
        System.out.println(s3 == s4);
    }

    private static void ___intern() {
        String s = new String( "abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s == s1.intern());
        System.out.println(s == s2.intern());
        System.out.println(s1 == s2.intern());
    }
}
