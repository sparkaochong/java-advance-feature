package com.ac.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestListFile1 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("J:" +File.separator+"装机必备");
        // 拿到这个文件目录下的所有的文件对象
        Stream<Path> pathStream = Files.list(path);
        pathStream.forEach(System.out::println);

        System.out.println("------------------------------------------------");

        // 拿到指定文件目录下的所有子文件
         printSubFiles(path);
    }

    /**
     * 递归打印指定文件目录中的所有子文件
     * @param path 文件目录的路径
     */
    public static void printSubFiles(Path path){
        System.out.println(path.getFileName());
        if(Files.isDirectory(path)){
            try {
                Stream<Path> pathStream = Files.list(path);
                pathStream.forEach(p -> {
                    System.out.println(p.getFileName());
                    printSubFiles(p);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
