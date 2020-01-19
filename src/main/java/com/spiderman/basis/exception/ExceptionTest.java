package com.spiderman.basis.exception;

import java.io.*;

/**
 * try-with-resource 使用
 * <p>具体说明</p>
 *
 * @author Spiderman
 * @version 1.9: com.spiderman.basis.exception.ExceptionTest,v 0.1 2020-01-10 17:00 Exp $$
 */
public class ExceptionTest {
    /**
     * 一个简单的复制文件方法。
     */
    public static void copy(String src, String dst) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dst);
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * try-with-resource
     *
     * @param src
     * @param dst
     */
    public static void copy1(String src, String dst) {

        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class finallyTest{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "finallyTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new finallyTest().finallyTT().toString());
    }

    private  finallyTest finallyTT() {
        finallyTest finallyTest = new finallyTest();
        try {
            finallyTest.name="张三";
            finallyTest.age=10;
            return finallyTest;
        }catch (Exception e){

        }finally {
            finallyTest.age=20;
        }
        return finallyTest;
    }
}
