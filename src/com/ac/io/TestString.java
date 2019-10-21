package com.ac.io;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Description:
 * <String字符串编码转换>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class TestString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "A学严";
        byte[] bytes = str.getBytes("UTF-16");
        System.out.println("所占字节数量：" + bytes.length);
        System.out.println("当前默认编码：" + Charset.defaultCharset().toString());
        str = new String(bytes,"UTF-16BE");
        System.out.println(str);

        // 产生乱码的根本原因：编码和解码使用的是不同的方式
        for(byte b: bytes){
            System.out.println(b);
        }
    }
}
