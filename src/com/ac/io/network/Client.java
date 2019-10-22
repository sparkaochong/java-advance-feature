package com.ac.io.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 构建客户端的 Socket
        Socket socket = new Socket("127.0.0.1",9001);

        System.out.println("客户端已启动！");

        // 拿到字节输出流
        OutputStream outputStream = socket.getOutputStream();

        // 拿到字节输入流
        InputStream inputStream = socket.getInputStream();

        System.out.println("客户端开始发送消息！");

        // 字节输出流 -> 可以写基本类型数据的输出流
        try(PrintStream printStream = new PrintStream(outputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            printStream.println("Hello World!");

            // 接收服务器端发送的消息
            String line = reader.readLine();
            System.out.println("服务器端发送过来的消息：" + line);
        }

        // 关闭客户端
        System.out.println("关闭客户端");
        socket.close();

    }
}
