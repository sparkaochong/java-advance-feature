package com.ac.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Description:
 * <字节输出流>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestOutputStream1 {
    public static void main(String[] args) {
        String path = "." + File.separator + "data" + File.separator + "word.txt";

        String content = "学Java";

        OutputStream outputStream = null;
        try {
            // UTF-8: 7个字节
            // 11100101 10101101 10100110 01001010 01100001 01110110 01100001
            // E5ADA64A617661
            byte[] bytes = content.getBytes("UTF-8");

            // 将这个字符串写入到当前目录下的 .\data\word.txt

            // 构建一个磁盘文件字节输出流(相当于打开了一个资源)
            // 默认的话，是覆盖原有的文件中原有的内容
            outputStream = new FileOutputStream(path, true);
            // 将所有的字节一次性输出到文件中

            outputStream.write(bytes);

            // 写入字节数组中指定的元素
            // off: 表示开始的下标
            // len: 表示需要写入字节的长度

            // outputStream.write(bytes, 3, 2);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                // 关闭资源
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
