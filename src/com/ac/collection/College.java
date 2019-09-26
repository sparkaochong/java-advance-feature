package com.ac.collection;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/25
 *
 * @author aochong
 * @version 1.0
 */
public class College {
    private String name;
    private static Course[] courses = new Course[12];

    static{
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
    }

    public College(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Course[] getCourses() {
        return courses;
    }

    public static void setCourses(Course[] courses) {
        College.courses = courses;
    }
}
