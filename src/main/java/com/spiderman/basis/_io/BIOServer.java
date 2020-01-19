package com.spiderman.basis._io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用java.io和java.net中的同步、阻塞式
 */
public class BIOServer extends Thread {
    private ServerSocket serverSocket;
    //引入线程池机制
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    public void run() {
        try {
            serverSocket = new ServerSocket(1111);
            while (true) {
                //阻塞等待客户端连接
                Socket socket = serverSocket.accept();
                //当连接建立后，启动一个单独线程负责回复客户端请求
                RequestHandler requestHandler = new RequestHandler(socket);
                executorService.execute(requestHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BIOServer server = new BIOServer();
        server.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), 1111)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        }
    }
}

// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
