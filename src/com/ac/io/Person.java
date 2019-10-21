package com.ac.io;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/15
 *
 * @author aochong
 * @version 1.0
 */
public class Person implements Serializable {
    public enum Gender {
        MALE,FEMALE
    }

    /**名字*/
    private String name;
    /**生日(出生日期)*/
    private LocalDate birthday;
    /**性别*/
    private transient Gender gender;
    /**邮箱*/
    private String email;

    public Person(String name, LocalDate birthday, Gender gender, String email) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取这个人的年龄
     * @return
     */
    public int getAge(){
        return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * 比较两个人的年龄
     * @param p1
     * @param P2
     * @return
     */
    public static int compareByAge(Person p1, Person P2){
        return p1.getAge() - P2.getAge();
    }

    public static List<Person> createRoster(){
        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Gender.MALE, "fred@example.com"));
        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Gender.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Gender.MALE, "george@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Person.Gender.MALE, "bob@example.com"));

        return roster;
    }
}
