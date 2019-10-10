package com.ac.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/28
 *
 * @author aochong
 * @version 1.0
 */
public class TestIterator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello","world","this","is","women");
        // 1. 普通 for 循环
        for(int index=0;index< list.size();index++){
            String element = list.get(index);
            System.out.print(element + "、");
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");

        // 2. foreach 循环
        for(String str: list){
            System.out.print(str + "、");
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");

        // 3. 迭代器
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + "、");
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");

        // 双向迭代器
        // 正向迭代
        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            System.out.print(listIterator.next() + "、");
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");

        // 反向迭代
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous() + "、");
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");

        // 4. 可以使用方法 forEach 进行迭代
        list.forEach(a -> System.out.print(a + "、"));

    }
}
