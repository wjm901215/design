package com.spiderman.basis.runtime;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0: com.spiderman.basis.runtime.RunTimeDemo,v 0.1 2020-06-22 22:30 Exp $$
 */
public class RunTimeDemo {

    public static void main(String[] args) {
        System.out.println("最大内存："+Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
    }
}
