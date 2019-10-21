package com.ac.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Description:
 * <字符输出流>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestWriter {
    public static void main(String[] args) {
        String str1 = "java.lang.Object(Java的始祖类)";
        String str2 = "java.lang.Exception(Java中的异常始祖类)";
        String str3 = "包装类(比如 java.lang.Integer、java.lang.Double等)";
        String path = "." + File.separator + "data" + File.separator + "charWriter.txt";

        // 将字节输出流包装成字符输出流
        try (Writer writer = new FileWriter(path)) {
            // 将字符串转成字符数组
            // char[] chars = content.toCharArray();

            // 讲一个字符写入到输出流
            // 真正写字符之前，先将字符放入到 JVM 内存(缓存)中
            writer.write(str1);
            writer.write("\n");
            writer.write(str2);
            writer.write("\n");
            writer.write(str3);
            writer.write("\n");

            // 当调用 flush 的时候才真正的将字符数据写入到磁盘文件中(落盘)
            // writer.flush();
            // 调用 close 的时候数据也会落盘
            // writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
