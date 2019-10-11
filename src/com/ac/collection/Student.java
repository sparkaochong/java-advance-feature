package com.ac.collection;

import java.util.ArrayList;
import java.util.Random;

/**
 * Description:
 * <学生实体>
 * Created by aochong on 2019/9/25
 *
 * @author aochong
 * @version 1.0
 */
public class Student extends Person {
    private College college;
    private String number;
    private int totalCregits;
    private ArrayList<Course> selectedCourses = new ArrayList<>();
    private int currentNumber;
    private static Random random = null;


    static {
        random = new Random();
    }

    public Student(String name, int age,String number) {
        super(name, age);
        this.number = number;
    }

    public Student(String name, int age, College college, int number) {
        super(name, age);
        this.college = college;
        this.number = String.valueOf(number);
    }

    public void selectedCourse() {
        Course[] courses = college.getCourses();
        // 随机生成一个下标值
        int index = random.nextInt(courses.length);
        selectedCourses.add(courses[index]);
        // 维护学生和课程之间的关系
        college.addStudentCourse(this,courses[index]);
        // 选择课程数 + 1
        totalCregits += courses[index].getCredits();
        // 学分进行累加
        currentNumber++;
    }



    public void studyCourse() {
        if (selectedCourses == null) {
            throw new RuntimeException("你还没有选择课程！");
        }
        int index = random.nextInt(selectedCourses.size());
        System.out.println("正在学习：" + selectedCourses.get(index));
    }

    public String getNumber() {
        return number;
    }

    public int getTotalCregits() {
        return totalCregits;
    }

    public void setTotalCregits(int totalCregits) {
        this.totalCregits = totalCregits;
    }

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Student.random = random;
    }

    public int getTotalCredits() {
        return totalCregits;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public College getCollege() {
        return college;
    }

    public void setNumber(int number) {
        this.number = String.valueOf(number);
    }

    public void setSelectedCourse(ArrayList<Course> courses) {
        this.selectedCourses = courses;
    }

    public ArrayList<Course> getSelectedCourse() {
        return selectedCourses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;
        if (this.number == other.number) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                '}';
    }
}
