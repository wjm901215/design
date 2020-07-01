package com.spiderman.basis.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.basis.function.FunctionDemo,v 0.1 2020-06-23 10:43 Exp $$
 */
public class FunctionDemo {
    public static void main(String[] args) {
        FunctionDemo demo = new FunctionDemo();
//        demo.functionTest();
//        demo.consumerTest();
//        demo.predicateTest();
        demo.supplierTest();
    }

    /**
     * 函数式函数
     */
    public void functionTest() {
//        Function<String,String> function = new Function<String,String>(){
//
//            @Override
//            public String apply(String var) {
//                System.out.println("入参数"+var);
//                return "test";
//            }
//        };
        Function<String, String> function = var -> {
            System.out.println("入参数" + var);
            return "apply";
        };
        String apply = function.apply("test");
        System.out.println(apply);

    }

    /**
     * 消费型函数
     */
    public void consumerTest() {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println("获取数据" + s);
//            }
//        };
        Consumer<String> consumer = (var) -> {
            System.out.println(var);
        };
        consumer.accept("test");
    }

    /**
     * 断定型函数
     */
    public void predicateTest() {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                System.out.println("入参"+s);
//                if (s.equals("yes")) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        };

        Predicate<String> predicate = (str) -> {
            System.out.println("入参" + str);
            if (str.equals("yes")) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println(predicate.test("yes"));
    }

    /**
     * 供给型函数
     */
    public void supplierTest() {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "获取数据";
//            }
//        };
        Supplier<String> supplier = () -> "获取数据";
        System.out.println(supplier.get());
    }
}
