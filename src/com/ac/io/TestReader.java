package com.ac.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Description:
 * <字符输入流>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestReader {
    public static void main(String[] args) {
        String path = "." + File.separator + "data" + File.separator + "charWriter.txt";

        try (Reader reader = new FileReader(path)) {
            // 读入一组字符
            char[] chars = new char[10];
            StringBuilder sb = new StringBuilder();
            String line = null;

            // 当 read 方法返回 -1 的时候，表示已经读到文件末尾了
            int charNum = -1;
            while((charNum = reader.read(chars))!=-1){

                for(char c: chars){
                    if('\n'!=c){
                        sb.append(c);
                    }else{
                        line = sb.toString();
                        System.out.println(line);
                        sb = new StringBuilder();
                    }
                }
                chars = new char[100];
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
