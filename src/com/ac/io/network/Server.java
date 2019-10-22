package com.ac.io.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 初始化一个 ServerScoket,并绑定监听端口
        ServerSocket serverSocket = new ServerSocket(9001);

        System.out.println("服务器已启动!");

        // 监听客户端是否链接
        Socket socket = serverSocket.accept();

        // 拿到 socket 的输入流
        InputStream inputStream = socket.getInputStream();

        // 拿到 socket 的输出流
        OutputStream outputStream = socket.getOutputStream();

        System.out.println("客户端已连接！");

        // 将字节输入流转成字符输入流
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintStream printStream = new PrintStream(outputStream)){
            // 将客户端的数据读入内存
            String line = reader.readLine();

            System.out.println("接收到的数据：" + line);

            // 进行消息的处理，将小心进行反转
            StringBuilder sb = new StringBuilder(line);
            String message = sb.reverse().toString();

            System.out.println("处理过后的数据：" + message);

            // 将反转之后的数据发送到客户端
            printStream.println(message);
        }

        // 关闭服务端
        System.out.println("关闭服务端");
        serverSocket.close();
    }
}
