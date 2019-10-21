package com.ac.collection.practice;

import java.util.Objects;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/17
 *
 * @author aochong
 * @version 1.0
 */
public class Student {
    private String number;
    private String name;
    private int score;

    public Student(String number, String name, int score) {
        this.number = number;
        this.name = name;
        this.score = score;
    }

    /**
     * 工具方法(没有状态)
     * 将字符串的学生信息转换成 Student 对象类型的信息
     * @param str 字符串的学生信息
     * @return Student 对象
     */
    public static Student fromStr(String str){
        String[] arr = str.split(",");
        Student student = new Student(arr[0],arr[1],Integer.parseInt(arr[2]));
        return student;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){return true;}
        if(o==null || getClass() != o.getClass()){return false;}
        Student student = (Student)o;
        return score == student.score &&
                Objects.equals(number,student.number) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
