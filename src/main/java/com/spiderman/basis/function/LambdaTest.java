package com.spiderman.basis.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 函数式接口
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.basis.function.LambdaTest,v 0.1 2020-06-23 17:53 Exp $$
 */
public class LambdaTest {

    public static void main(String[] args) {
        User a = new User("A", 10);
        User b = new User("B", 20);
        User c = new User("C", 30);
        User d = new User("D", 40);
        User e = new User("E", 50);
        User f = new User("F", 60);
        List<User> lists = Arrays.asList(a, b, c, d, e, f);
        lists.stream()
                .filter(user -> user.age > 30)
                .map(user -> user.name.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);
    }

    static class User {
        public String name;
        public int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
