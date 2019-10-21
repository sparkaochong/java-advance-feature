package com.ac.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 * <try with resources 代码块>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestInputStream2 {
    public static void main(String[] args) {
        // 从文件 .\data\word.txt 中读取内容，放到内存中
        String path = "." + File.separator + "data" + File.separator + "word.txt";


        try(InputStream inputStream = new FileInputStream(path)) {
            // 从文件的输入字节流中读入一个字节
            int b = -1;
            int byteNum = inputStream.available();
            byte[] bytes = new byte[byteNum];
            // 将读入的字节放入到指定的字节数组中
            inputStream.read(bytes);

            String str = new String(bytes,"UTF-8");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
