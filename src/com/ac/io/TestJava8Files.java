package com.ac.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestJava8Files {
    public static void main(String[] args) {
        // 创建一个文件路径
        Path path = Path.of("." + File.separator +"data" + File.separator + "word.txt");

        if(Files.exists(path)){
            try {
                // 删除不存在的文件的时候会抛出异常：IOException
                Files.delete(path);
                // 拿到父亲目录路径
                Path parentPath = path.getParent();
                // 删除父亲目录
                Files.delete(parentPath);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            // 拿到父亲目录路径
            Path parentPath = path.getParent();
            try {
                // 创建父亲目录
                Files.createDirectory(parentPath);
                // 创建文件
                Files.createFile(path);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
