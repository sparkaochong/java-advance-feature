package com.ac.collection;

import java.util.ArrayList;

/**
 * Description:
 * <学生选课系统>
 * Created by aochong on 2019/9/25
 *
 * @author aochong
 * @version 1.0
 */
public class CourseSelectSystem {
    public static void main(String[] args) {
        College college = new College("浙江大学计算机学院");

        Student s1 = new Student("张三",22,college,0511001);
        // 选课
        while(s1.getTotalCredits()<70){
            s1.selectedCourse();
        }

        // 该学生选择了哪些课程
        ArrayList<Course> courses = s1.getSelectedCourse();
        System.out.println("选择了：" + courses);
        System.out.println("课程数：" + courses.size());
        System.out.println("总学分：" + s1.getTotalCredits());

        // 正在学习课程
        s1.studyCourse();
    }
}
