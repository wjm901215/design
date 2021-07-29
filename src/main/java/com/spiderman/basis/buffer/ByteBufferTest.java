package com.spiderman.basis.buffer;

import java.nio.ByteBuffer;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.basis.buffer.ByteBufferTest,v 0.1 2021/6/25 18:10 Exp $$
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put("123456".getBytes());
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            char c = (char) buffer.get();
            System.out.println(c);
            if (buffer.position() == 3) {
                buffer.mark();
            }
            char a = 0, b;
            if (buffer.position() == 4) {
                a = f(c);
            }
            if (buffer.position() == 5) {
                b = f(c);
                try {
                    System.out.println(g(a, b));
                    throw new Exception("主动抛出");
                } catch (Exception e) {
                    buffer.reset();
                }
            }
        }
    }

    private static String g(char a, char b) {
        return String.valueOf(a + b);
    }

    private static char f(char c) {
        return 't';
    }
}
