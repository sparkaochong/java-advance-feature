package com.ac.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * <学院实体类>
 * Created by aochong on 2019/9/25
 *
 * @author aochong
 * @version 1.0
 */
public class College {
    /**学院的名称*/
    private String name;
    /**学院可以设置多门课程，学生随机选择课程进行学习*/
    /**所有的课程是在学院成立的时候就已经设置好了*/
    /**
     * 我们可以使用 HashMap 来存储学院的课程信息
     * key 是课程的名称，value 是课程对象
     * 每一个学院的课程都是不一样的
     * */
    private Map<String,Course> courseMap = new HashMap<>();
    //private static Course[] courses = new Course[12];
    /**学院可以有很多个学员*/
    private List<Student> students = new LinkedList<>();

    /**每一个学生分别选了哪些课*/
    private Map<Student,List<Course>> studentCourseMap = new HashMap<>();
    /**每门课程分别被哪些学生选了*/
    private Map<Course,List<Student>> courseStudentMap = new HashMap<>();

    /*static{
        // 初始化课程
        courses[0] = new Course(1, "高数", 6);
        courses[1] = new Course(2, "Java程序开发", 10);
        courses[2] = new Course(3, "操作系统", 9);
        courses[3] = new Course(4, "思想政治", 5);
        courses[4] = new Course(5, "英语", 10);
        courses[5] = new Course(6, "C语言", 10);
        courses[6] = new Course(7, "体育", 2);
        courses[7] = new Course(8, "编译原理", 7);
        courses[8] = new Course(9, "概率统计", 5);
        courses[9] = new Course(10, "计算机网络", 6);
        courses[10] = new Course(11, "线性代数", 5);
        courses[11] = new Course(12, "电子电路原理", 2);
    }*/

    public College(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course[] getCourses() {
        // 拿到所有的课程信息
        // 拿到 hashMap 中所有的value
        Collection<Course> courses = courseMap.values();
        return courses.toArray(new Course[courses.size()]);
    }

    public Map<String, Course> getCourseMap() {
        return courseMap;
    }

    /**
     * 维护学生和课程之间的关系，用于学生选课的时候进行调用
     * @param student 学生
     * @param course 学生选的课程
     */
    public void addStudentCourse(Student student, Course course){
        // 1. 维护学生和课程之间的关系
        // 先拿到这个学生选的所有的课程
        List<Course> courses = studentCourseMap.get(student);
        // 学生第一次选课
        if(courses==null){
            List<Course> list = new ArrayList<>();
            list.add(course);
            studentCourseMap.put(student,list);
        }else{
            courses.add(course);
        }

        // 2. 维护课程和学生之间的关系
        // 先拿到选择了这门课程的所有学生
        List<Student> students = courseStudentMap.get(course);
        if(students==null){
            List<Student> list = new ArrayList<>();
            list.add(student);
            courseStudentMap.put(course,list);
        }else{
            students.add(student);

        }
    }

    public void setCourseMap(Map<String, Course> courseMap) {
        this.courseMap = courseMap;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Map<Student, List<Course>> getStudentCourseMap() {
        return studentCourseMap;
    }

    public void setStudentCourseMap(Map<Student, List<Course>> studentCourseMap) {
        this.studentCourseMap = studentCourseMap;
    }

    public Map<Course, List<Student>> getCourseStudentMap() {
        return courseStudentMap;
    }

    public void setCourseStudentMap(Map<Course, List<Student>> courseStudentMap) {
        this.courseStudentMap = courseStudentMap;
    }

    @Override
    public String toString() {
        return "College{" +
                "name='" + name +
                '}';
    }
}
