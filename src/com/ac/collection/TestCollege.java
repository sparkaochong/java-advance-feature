package com.ac.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/26
 *
 * @author aochong
 * @version 1.0
 */
public class TestCollege {
    public static void main(String[] args) {
        College college = new College("浙江大学计算机学院");
        Collection<Student> students = college.getStudents();
        // 1. 判断集合是否是空集合
        boolean isEmpty = students.isEmpty();
        // true
        System.out.println(isEmpty);
        if(isEmpty){
            Student s1 = new Student("张三",20,college,1);
            // 招收第一个学员
            students.add(s1);
        }
        // false
        System.out.println(students.isEmpty());

        // 2. 查询集合中有多少个元素
        System.out.println("学生的个数：" + students.size());

        // 3. 判断是否有名字为 张三 ，学号为 0051001 的学员
        Student s = new Student("张三",20,college,2);
        boolean result = students.contains(s);
        // contains 依赖集合中元素的 equals 方法
        System.out.println(result);

        // 招收第二个学员
        Student s2 = new Student("李四",25,college,3);
        college.addStudent(s2);

        // 招收第三个学员
        Student s3 = new Student("王五",22,college,4);
        college.addStudent(s3);

        System.out.println(students.size());

        // 4. 集合和数组之间的转换
        // 发生了类型丢失
        Object[] objects = students.toArray();
        // 保留了类型
        Student[] studentArray = students.toArray(new Student[students.size()]);

        for(Student student: students){
            System.out.println(student);
        }

        // 支持 lambda 表达式
        // studentArray = students.toArray(size -> new Student[size]);

        /*studentArray = students.toArray(new IntFunction<Student[]>() {
            @Override
            public Student[] apply(int size) {
                return new Student[size];
            }
        });*/



        // 将数组转换成集合
        List<Student> list = Arrays.asList(studentArray);

        // 5. 集合元素更改的API
        students.add(new Student("麻子",21,college,5));
        System.out.println("学生个数：" + students.size());
        // 批量添加
        Student st1 = new Student("aa",22,college,6);
        Student st2 = new Student("aa",22,college,7);
        Student st3 = new Student("aa",22,college,8);
        students.addAll(Arrays.asList(st1,st2,st3));

        System.out.println("学生个数：" + students.size());
        // 从集合中删除指定元素
        students.remove(st1);
        System.out.println(students);

        students.removeIf(a -> a.getNumber().compareTo("6")>0);
        /*students.removeIf(new Predicate<Student>(){
            @Override
            public boolean test(Student student) {
                return student.getNumber()>6;
            }
        });*/
        System.out.println(students);

        students.clear();
        System.out.println("学生个数：" + students.size());
    }
}
