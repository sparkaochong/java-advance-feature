package com.ac.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Description:
 * <Collection之间的转换>
 * Created by aochong on 2019/10/10
 *
 * @author aochong
 * @version 1.0
 */
public class TestCollectionTransform {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        System.out.println(list);

        // ArrayList -> LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        System.out.println(linkedList);

        // LinkedList -> ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(linkedList);
        System.out.println(arrayList);

        // ArrayList -> HashSet
        // 去重
        HashSet<Integer> hashSet = new HashSet<>(list);
        System.out.println(hashSet);

        // LinkedList -> HashSet
        hashSet = new HashSet<>(linkedList);
        System.out.println(hashSet);

        // HashSet -> ArrayList
        list = new ArrayList<>(hashSet);
        System.out.println(list);

        // HashSet -> LinkedList
        linkedList = new LinkedList<>(hashSet);
        System.out.println(linkedList);
    }
}
