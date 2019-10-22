package com.ac.io.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class QqServer {
    public static void main(String[] args) throws IOException {
        // 初始化一个 ServerScoket,并绑定监听端口
        ServerSocket serverSocket = new ServerSocket(9001);

        System.out.println("服务器已启动!");

        while (true){
            // 监听客户端是否链接
            Socket socket = serverSocket.accept();

            // 拿到 socket 的输入流
            InputStream inputStream = socket.getInputStream();

            // 拿到 socket 的输出流
            OutputStream outputStream = socket.getOutputStream();

            // 将字节输入流转成字符输入流
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PrintStream printStream = new PrintStream(outputStream)){
                Scanner scanner = new Scanner(System.in);
                while(true){
                    // 将客户端的数据读入内存
                    String line = reader.readLine();
                    System.out.println(line);

                    // 将消息发送给客户端
                    System.out.println("我说：");
                    String response = scanner.nextLine();
                    printStream.println("小芳：" + response);

                    // 结束会话
                    if(response.equals("bye")||line.equals("bye")){
                        System.out.println("聊天结束！");
                        serverSocket.close();
                        break;
                    }
                }
            }
        }


    }
}
