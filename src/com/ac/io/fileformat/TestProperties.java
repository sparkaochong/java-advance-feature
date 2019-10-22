package com.ac.io.fileformat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Description:
 * <解析属性文件>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class TestProperties {
    public static void main(String[] args) {
        // 解析属性文件
        Properties properties = new Properties();

        try(BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("." + File.separator + "data" + File.separator + "test.properties"),"UTF-8"))){
            //new FileReader("." + File.separator + "data" + File.separator + "test.properties", StandardCharsets.UTF_8))
            properties.load(reader);
            String value = properties.getProperty("name");
            System.out.println(value);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
