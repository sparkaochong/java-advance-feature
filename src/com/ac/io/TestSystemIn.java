package com.ac.io;

import java.util.Scanner;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class TestSystemIn {
    public static void main(String[] args) {
        // 从控制台中输入数据到 JVM 内存
        try(Scanner scanner = new Scanner(System.in)){
            while(true){
                // 等待从控制台输入的数据
                /*System.out.println("请输入数字：");
                String line = scanner.nextLine();
                if(line.matches("\\d+")){
                    int num = Integer.parseInt(line);
                    System.out.println("平方：" + Math.pow(num,2));
                }else{
                    System.out.println("你输入的不是数字，请重新输入数字");
                }*/
            }
        }
    }
}
