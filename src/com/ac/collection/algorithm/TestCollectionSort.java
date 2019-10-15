package com.ac.collection.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/15
 *
 * @author aochong
 * @version 1.0
 */
public class TestCollectionSort {
    public static void main(String[] args) {
        // List 排序
        List<Integer> list = Arrays.asList(12,3,4,22,14,16);

        // 1. 先转成数组
        Integer[] arr = list.toArray(new Integer[list.size()]);

        // 2. 对数组进行排序
        Arrays.sort(arr);

        // 3. 转回集合
        list = Arrays.asList(arr);

        // 使用 Java 内置的排序方法对集合进行排序
        Collections.sort(list);

        // 集合的排序最终是通过数组排序实现的

        System.out.println(list);

        // Set 排序
        // HashSet：不允许有重复元素，没有顺序
        // java.util.TreeSet：不允许元素重复，排好序的(默认是升序排列)
        Set<Integer> set = new TreeSet<>((o1,o2) -> -o1.compareTo(o2));
        set.add(22);
        set.add(2);
        set.add(23);
        set.add(2);
        set.add(12);
        set.add(23);

        System.out.println(set);

        // Map 排序
        // java.util.TreeMap 对 key 进行排序(默认是升序排列)
        Map<Integer,String> map = new TreeMap<>((o1,o2) -> -o1.compareTo(02));
        map.put(1,"Hello");
        map.put(3,"Ketty");
        map.put(2,"World");
        map.put(3,"China");
        map.put(1,"Cat");
        map.put(5,"Dog");

        System.out.println(map);
    }
}
