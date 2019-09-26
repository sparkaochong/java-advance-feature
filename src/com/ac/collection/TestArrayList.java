package com.ac.collection;

import java.util.ArrayList;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/25
 *
 * @author aochong
 * @version 1.0
 */
public class TestArrayList {
    public static void main(String[] args) {
        // 数组列表，通过给数组扩容来解决数组长度固定的问题
        // 初始化一个数组列表
        ArrayList<Integer> list = new ArrayList<>();

        // 往 list 中增加5个元素
        list.add(1);
        list.add(10);
        list.add(14);
        list.add(78);
        list.add(54);

        // 这个时候，数组列表的长度已经达到5了
        // 对数组列表进行扩容
        // 这个时候数组列表的长度 5 + 5/2 = 7
        list.add(18);
        list.add(19);

        // 这个时候数组列表的长度 7 + 7/2 = 7 + 3 = 10
        list.add(14);
        list.add(12);
        list.add(68);

        System.out.println(list);

        list.remove(3);
        list.removeIf(integer -> integer>10);

        // ArrayList 是可以自动扩容的数组
        // ArrayList 也可以通过下标随机访问元素
        System.out.println("=====================================================");
        System.out.println(list);
    }
}
