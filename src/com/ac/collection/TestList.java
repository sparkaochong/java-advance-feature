package com.ac.collection;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/28
 *
 * @author aochong
 * @version 1.0
 */
public class TestList {
    public static void main(String[] args) {
        College college = new College("浙江大学计算机学院");
        List<Student> students = college.getStudents();

        // 1. 继承 Collection 中所有的方法
        // 批量添加
        Student st1 = new Student("aa",22,college,6);
        Student st2 = new Student("aa",22,college,7);
        Student st3 = new Student("aa",22,college,8);
        students.addAll(Arrays.asList(st1,st2,st3));

        // 2. 和下标相关的方法
        // 增：指定下标插入元素
        students.add(new Student("张三",23,college,0));
//        System.out.println(students);

        // 2. 和下标相关的方法
        // 增；指定下标插入元素
        students.add(2,new Student("李四",23,college,1));
        System.out.println(students);
        // 删：指定下标删除元素
        students.remove(3);
        System.out.println(students);
        // 改：指定下标修改元素的值
        students.set(2,new Student("李四",23,college,2));
        System.out.println(students);
        // 查：指定下标查询元素
        Student student = students.get(2);
        System.out.println(student);

        // 3. subList
        List<String> list = Arrays.asList("Hello","world","this","is","women");
        // 截取区间[1,3)
        List<String> subList = list.subList(1,3);
        System.out.println(subList);
    }
}
