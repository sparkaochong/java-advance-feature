package com.ac.io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 * <文件元数据操作>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestFileMetaData {
    public static void main(String[] args) {
        // 文件包含两部分数据：
        // 1. 元数据(metadata)：文件名称、文件最后修改时间、文件大小等。
        // 2. 真实数据(data)

        // Java 中怎么操作元数据呢？
        File file = new File("E:"+File.separator+"temp"+File.separator+"大数据时代.pdf");
        if(file.exists()){
            System.out.println("文件名称：" + file.getName());
            System.out.println("文件路径：" + file.getPath());
            System.out.println("文件绝对路径：" + file.getAbsolutePath());
            // 判断文件对象是否是文件目录
            System.out.println(file.isDirectory()? "是一个文件目录" : "是一个文件");
            System.out.println(file.isFile() ? "是一个文件" : "是一个文件目录");
            // 拿到文件最后修改时间
            Date date = new Date(file.lastModified());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("文件最后修改时间：" + simpleDateFormat.format(date));
            // 拿到文件的大小
            System.out.println("文件大小：" + file.length()/1024.0/1024.0 + "MB");
            // 判断一个文件是否是隐藏文件
            boolean isHidden = file.isHidden();
            System.out.println(isHidden ? "是一个隐藏文件" : "不是一个隐藏文件");
        }
    }
}
