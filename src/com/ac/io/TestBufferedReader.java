package com.ac.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class TestBufferedReader {
    public static void main(String[] args) {
        String path = "." + File.separator + "data" + File.separator + "charWriter.txt";
        // 重点记住
        // BufferedReader：读取的时候，会先将读取到的数据放到缓存(内存)当中
        // 提高性能
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(path))){
            String line = null;
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
