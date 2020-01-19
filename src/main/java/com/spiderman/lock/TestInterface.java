package com.spiderman.lock;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author Spiderman
 * @version 1.0.0: com.spiderman.lock.TestInterface,v 0.1 2020-01-10 11:49 Exp $$
 */
public interface TestInterface {

    void test();

    static void tesst1() {
        System.out.println("tt");
    }
    default void tesst2() {
        System.out.println("tt");
    }
    default void tesst3() {
        System.out.println("tt");
    }
}
