package com.ac.collection.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/17
 *
 * @author aochong
 * @version 1.0
 */
public class TestList {
    public static void main(String[] args) {
        // 1. 把字符串中的学生信息分离出来，如下：
        String str = "01,勇哥,100;02,老汤,98;03,明哥,90;04,菲力,89;05,杨哥,60";
        String[] strings = str.split(";");
        for(String s:strings){
            System.out.println(s);
        }

        // 2. 创建 List 集合，根据分离出来的学生信息创建学生对象，添加到 List 集合中
        List<Student> students = new ArrayList<>();
        for(String s:strings){
            Student student = Student.fromStr(s);
            students.add(student);
        }

        System.out.println("----------------------------------------------------------------");

        // 3. 通过迭代分别打印集合中的学生信息
        Iterator<Student> iter = students.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("----------------------------------------------------------------");

        // 4. 判断集合中是否存在姓名为 明哥 的学生
        Student s1 = new Student("03","明哥",90);
        boolean isExists = students.contains(s1);
        System.out.println(isExists);

        System.out.println("----------------------------------------------------------------");

        // 迭代器只能使用一次
        iter = students.iterator();
        while(iter.hasNext()){
            Student student = iter.next();
            if(student.getName().equals("明哥")){
                System.out.println("存在明哥这个学生");
                break;
            }
        }

        System.out.println("----------------------------------------------------------------");

        // 5. 通过循环打印集合中的学生信息
        for(Student student:students){
            System.out.println(student);
        }

        System.out.println("----------------------------------------------------------------");

        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }

        System.out.println("----------------------------------------------------------------");

        // 6. 删除姓名为 明哥 的学生
        /*students.removeIf(student -> {
            if(student.getName().equals("明哥")){
                return true;
            }
            return false;
        });*/

        /*for(int i=0;i<students.size();i++){
            if(students.get(i).getName().equals("明哥")){
                students.remove(students.get(i));
            }
        }*/

        iter = students.iterator();
        while(iter.hasNext()){
            Student student = iter.next();
            if(student.getName().equals("明哥")){
                iter.remove();
                break;
            }
        }

        System.out.println(students);

        System.out.println("----------------------------------------------------------------");

        // 7. 通过 foreach 循环打印集合中的学生的信息
        students.forEach(student -> System.out.println(student));
    }
}
