package com.ac.io;

import java.io.File;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestListFile {
    public static void main(String[] args) {
        File file = new File("J:" +File.separator+"装机必备");
        // 拿到这个文件目录下的所有的文件对象
        File[] files = file.listFiles();
        // 打印子文件目录的名称

        /*for(File f: files){
            System.out.println(f.getName());
        }*/

        // 拿到指定文件目录下的所有子文件
        printSubFiles(file);
    }

    /**
     * 递归打印指定文件目录中的所有子文件
     * @param file 文件对象
     */
    public static void printSubFiles(File file){
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[] subFiles = file.listFiles();
            for(File subFile: subFiles){
                System.out.println(subFile.getName());
                // 递归打印子文件目录中的子文件
                printSubFiles(subFile);
            }
        }
    }
}
