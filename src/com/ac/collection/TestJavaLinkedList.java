package com.ac.collection;

import java.util.LinkedList;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/26
 *
 * @author aochong
 * @version 1.0
 */
public class TestJavaLinkedList {
    public static void main(String[] args) {
        // Java内置的链表，双向链表
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 增：向链表中增加元素
        // 向链表的尾部插入一个节点
        linkedList.add(5);
        linkedList.add(12);
        linkedList.add(9);
        linkedList.add(3);

        // 向链表头部插入一个节点
        linkedList.addFirst(89);

        System.out.println(linkedList);

        // 从头开始删除
        linkedList.remove();

        // 2 是链表下标
        linkedList.remove(2);

        // 删：删除指定元素
        linkedList.remove(Integer.valueOf("12"));

        // 改：设置某个值(将第2个元素设置成100)
        // [5,100]
        linkedList.set(1,100);

        System.out.println(linkedList);
        // 查：根据下标查询某个值(性能较差)
        System.out.println(linkedList.get(1));
    }
}
