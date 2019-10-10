package com.ac.collection.hashtable;

import com.ac.collection.Student;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/28
 *
 * @author aochong
 * @version 1.0
 */
class EntryNode{
    String key;
    Student value;
    EntryNode next;

    public EntryNode(String key,Student value){
        this.key = key;
        this.value = value;
    }

}
public class TestHashTable2 {
    public static void main(String[] args) {
        Student s1 = new Student("张三",20,"051100");
        Student s2 = new Student("李四",21,"051101");
        Student s3 = new Student("王二",23,"051102");
        Student s4 = new Student("麻子",24,"051103");
        Student s5 = new Student("刘七",19,"051104");
        Student s6 = new Student("小八",21,"061104");

        // 散列表
        EntryNode[] students = new EntryNode[5];
        // 存储数据
        put("051100",s1,students);
        put("051101",s2,students);
        put("051102",s3,students);
        put("051103",s4,students);
        put("051104",s5,students);
        put("061104",s6,students);
        // 获取数据，通过 key 拿到对应的value
        System.out.println(get("051102",students));
        System.out.println(get("061104",students));


    }

    /**
     * 根据 key 拿到对应的value
     * @param key
     * @param students
     * @return
     */
    public static Student get(String key,EntryNode[] students){
        // 计算 hash 值
        int hash = hash(key);
        // 拿到对应下标的链表头节点
        EntryNode head = students[hash];
        if(head==null){
            return null;
        }else{
            EntryNode curr = head;
            // 循环遍历链表的每一个节点，对比key 相等的话，表示找到了，直接返回true
            while(curr!=null){
                if(curr.key.equals(key)){
                    return curr.value;
                }
                curr = curr.next;
            }
            return null;
        }
    }

    /**
     * 将 key-value 数据放到散列表中 students 中
     * @param key
     * @param value
     * @param students
     */
    public static void put(String key,Student value,EntryNode[] students){
        // 创建一个节点
        EntryNode node = new EntryNode(key,value);
        // 计算 key 的 hash 值
        int hash = TestHashTable2.hash(key);
        // 拿到对应列表的头
        EntryNode head = students[hash];
        if(head == null){
            // 直接将需要插入的节点作为头节点
            students[hash] = node;
        }else{
            // 找到链表的尾节点
            EntryNode last = head;
            EntryNode curr = head.next;
            while(curr!=null){
                last = curr;
                curr = curr.next;
            }
            // 将需要插入的数据插入到最后节点的 next
            last.next = node;
        }
    }

    /**
     * 散列函数
     * 通过学号得到下标
     * @param key 学号
     * @return 下标
     */
    public static int hash(String key){
        String lastTwoChars = key.substring(key.length()-2);
        return Integer.valueOf(lastTwoChars);
    }

}
