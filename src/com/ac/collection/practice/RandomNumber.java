package com.ac.collection.practice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/20
 *
 * @author aochong
 * @version 1.0
 */
public class RandomNumber {
    public static void main(String[] args) {
        // 生成 10 个 0 到 19 之间的不重复的随机数
        // 1. 生成随机数，需要Random类
        Random random = new Random();
        // 2. 生成的数字是不重复的，可以使用 HashSet
        Set<Integer> set = new HashSet<>();
        // 3. 10个，判断，如果 set 的大小小于10个的话，就要一直往 set 中添加数字
        while(set.size()<10){
            Integer number = random.nextInt(20);
            set.add(number);
        }
        System.out.println(set);
    }
}
