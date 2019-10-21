package com.ac.io;

import java.io.File;
import java.io.IOException;

/**
 * Description:
 * <File对象操作>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestFile {
    public static void main(String[] args) {
        // 创建一个文件对象
        // 需要参数：文件的路径以及文件名
        // 路径的分隔符：在 windows 系统上使用 "\"来表示，在 Linux 操作系统上使用 "/" 来表示
        // E:\temp\word.txt windows
        // /home/hadoop-ac/word.txt linux

        // System.out.println(File.separator);

        // 绝对路径：windows从盘符开始的路径，linux 是指从根目录开始
        // 相对路径：相对一个文件目录开始
        // "E:" + File.separator + "temp" + File.separator +
        // 相对于当前的项目(project)的目录
        // . 就是当前的项目(project)的目录
        File file = new File("." + File.separator + "data" + File.separator + "word.txt");
        // 判断文件是否存在
        boolean isExists = file.exists();

        if(isExists){
            // 删除一个文件
            boolean isFileDelete = file.delete();
            System.out.println(isFileDelete ? "文件删除成功" : "文件删除失败");
            // 拿到文件的父亲目录
            File parentFile = file.getParentFile();
            // 删除父亲目录
            parentFile.delete();
        }else{
            // 拿到文件的父亲目录
            File parentFile = file.getParentFile();
            if(!parentFile.exists()){
                // 创建文件目录
                parentFile.mkdir();
            }

            // 创建文件
            try {
                boolean isCreatedSucc = file.createNewFile();
                System.out.println(isCreatedSucc ? "文件创建成功" : "文件创建失败");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
