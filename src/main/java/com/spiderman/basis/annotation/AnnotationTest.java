package com.spiderman.basis.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 注解测试
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.basis.annotation.AnnotationTest,v 0.1 2020-07-01 09:00 Exp $$
 */
public class AnnotationTest {
    @AnnotationTest1
    public void test01() {

    }
}

class ReflectionTest{
    public static void main(String[] args) {
        Class<?> annotationTest = null;
        try {
            annotationTest = Class.forName("com.spiderman.basis.annotation.AnnotationTest");
            Method[] methods = annotationTest.getMethods();
            for (Method method : methods) {
                System.out.println("methodName："+method.getName());
                Annotation annotation = method.getAnnotation(AnnotationTest1.class);
                if(annotation!=null) {
                    System.out.println("annotation：" + annotation.toString());
                }
            }
            System.out.println("---------------------------------------------");
            Constructor<?>[] declaredConstructors = annotationTest.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor.getModifiers());
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

/**
 * @author wangjunma
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationTest1 {
    String name() default "张三";

    int age() default 0;
}
