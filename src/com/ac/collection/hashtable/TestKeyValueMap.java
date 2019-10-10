package com.ac.collection.hashtable;

import com.ac.collection.Student;

import java.util.HashMap;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/9
 *
 * @author aochong
 * @version 1.0
 */
public class TestKeyValueMap {
    public static void main(String[] args) {
        Student s1 = new Student("张三",20,"051100");
        Student s2 = new Student("李四",21,"051101");
        Student s3 = new Student("王二",23,"051102");
        Student s4 = new Student("麻子",24,"051103");
        Student s5 = new Student("刘七",19,"051104");
        Student s6 = new Student("小八",21,"061104");

        // loadFactor 装载因子
        // loadFactor * 数组的长度(5)
        // java.util.HashMap 替换掉KeyValueMap
        // 1. 数组 + 链表，对应的数组：Node<K,V>[] table
        // 2. 数组默认长度是 16
        // 3. 也有散列函数，也是使用 key 的 hashCode 来实现的
        // 4. loadFactor(装载因子)，默认值是0.75 。 0.75 * 16 = 12
        // 5. 当元素的个数大于12的时候，数组自动扩容两倍
        HashMap<String,Student> map = new HashMap<>(20,1.45f);
        map.put("051100",s1);
        map.put("051101",s2);
        map.put("051102",s3);
        map.put("051103",s4);
        map.put("051104",s5);
        map.put("061104",s6);

        System.out.println(map.get("061104"));
        System.out.println(map.get("051104"));
    }
}
