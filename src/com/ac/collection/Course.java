package com.ac.collection;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/25
 *
 * @author aochong
 * @version 1.0
 */
public class Course {
    private int id;
    private String name;
    private int credits;

    public Course(int id,String name,int credits){
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
