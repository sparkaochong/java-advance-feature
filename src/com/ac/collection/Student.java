package com.ac.collection;

import java.util.ArrayList;
import java.util.Random;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/25
 *
 * @author aochong
 * @version 1.0
 */
public class Student extends Person{
    private College college;
    private int number;
    private int totalCregits;
    private ArrayList<Course> selectedCourses = new ArrayList<>();
    private int currentNumber;
    private static Random random = null;


    static{
        random = new Random();
    }

    public Student(String name,int age,College college,int number){
        super(name,age);
        this.college = college;
        this.number = number;
    }

    public void selectedCourse(){
        Course[] courses = College.getCourses();
        int index = random.nextInt(courses.length);
        selectedCourses.add(courses[index]);
        totalCregits += courses[index].getCredits();
        currentNumber++;
    }

    public void studyCourse(){
        if(selectedCourses==null){
            throw new RuntimeException("你还没有选择课程！");
        }
        int index = random.nextInt(selectedCourses.size());
        System.out.println("正在学习：" + selectedCourses.get(index));
    }

    public int getTotalCredits(){
        return totalCregits;
    }

    public void setCollege(College college){
        this.college = college;
    }

    public College getCollege(){
        return college;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setSelectedCourse(ArrayList<Course> courses){
        this.selectedCourses = courses;
    }

    public ArrayList<Course> getSelectedCourse(){
        return selectedCourses;
    }
}
