package com.ac.io;

import java.io.File;
import java.util.ArrayList;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestFile2 {
    private static int number;
    public static void main(String[] args) {
        //传入一个目录，以树形方式展现该目录中的所有子目录和文件，另外，在展现的时候将目录排在上面，文件排在
        //下面，每一层要加上缩进
        File f = new File("J:" +File.separator+"装机必备");
        printFileName(f);
    }

    public static void printFileName(File file){
        if(file.isDirectory() && 0 != file.listFiles().length){
            File[] files = file.listFiles();
            files = sortFile(files);
            for(File f : files){
                StringBuffer sb = new StringBuffer();
                if(f.isFile()){
                    sb.append(getTab(number));
                    sb.append(f.getName());
                }else{
                    sb.append(getTab(number));
                    sb.append(f.getName());
                    sb.append("\\");
                }
                System.out.println(sb);
                if(f.isDirectory()){
                    number++;
                    printFileName(f);
                    number--;
                }
            }
        }
    }

    //得到子目录前需要加多少tab
    private static String getTab(int number){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < number; i++){
            sb.append("\t");
        }
        return sb.toString();
    }

    //对子目录进行排序，文件夹在前，文件在后
    private static File[] sortFile(File[] files) {
        ArrayList<File> list = new ArrayList<File>();
        for(File f : files){
            if(f.isDirectory()){
                list.add(f);
            }
        }
        for(File f : files){
            if(f.isFile()){
                list.add(f);
            }
        }
        return list.toArray(new File[files.length]);
    }
}
