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
public class TestHashTable {
    public static void main(String[] args) {
        Student s1 = new Student("张三",20,"051100");
        Student s2 = new Student("李四",20,"051101");
        Student s3 = new Student("王二",20,"051102");
        Student s4 = new Student("麻子",20,"051103");
        Student s5 = new Student("刘七",20,"051104");

        // 051102：05表示年级，11表示班级，02表示编号
        // 通过散列函数将 key 转成下标
        // 通过下标将 key 对应的 value 存储在对应的位置上

        Student[] students = new Student[5];
        students[hash(s1.getNumber())] = s1;
        students[hash(s2.getNumber())] = s2;
        students[hash(s3.getNumber())] = s3;
        students[hash(s4.getNumber())] = s4;
        students[hash(s5.getNumber())] = s5;

        // 通过学号快速找到对应的学生
        System.out.println(students[3]);

        // 目标：通过某个 key 访问对应的 value。通过 学号 访问对应的学生
        // 将key 转换成数组对应的下标，然后通过下标来访问数组中的元素，将学号转成下标
        System.out.println(hash("051102"));
        System.out.println(hash("051102"));
        // 散列冲突，导致数据丢失
        Student s6 = new Student("王六",20,"061102");
        students[hash(s6.getNumber())] = s6;
//        System.out.println(Arrays.toString(students));
        // 通过学号快速找到对应的学生
        String number = "051102";
        int index = Integer.valueOf(hash(number));
        System.out.println(students[index]);

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

    /**
     * 通过学号得到下标
     * @param number 学号
     * @return 下标
     */
    public static int hash(int number){
        return number;
    }
}
