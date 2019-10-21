package com.ac.collection.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/16
 *
 * @author aochong
 * @version 1.0
 */
class ComparsionProvider{
    public int compareByName(Person p1,Person p2){
        return p1.getName().compareTo(p2.getName());
    }

    public int compareByAge(Person p1,Person p2){
        return p1.getAge() - p2.getAge();
    }
}
public class TestMethodRefence {
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        // 对花名册按照年龄排序
        // 为了使得 Lambda 表达式根据的简洁，我们可以使用方法引用来代替 Lambda 表达式
        // Collections.sort(roster, (o1, o2) -> Person.compareByAge(o1,o2));
        // Collections.sort(roster, (o1, o2) -> (o1.getAge()-o2.getAge()));
        // 引用一个静态的方法, ClassName::MethodName
        // Collections.sort(roster, Person::compareByAge);

        // 引用一个对象实例方法，对象::方法
        ComparsionProvider comparsionProvider = new ComparsionProvider();
        Collections.sort(roster,comparsionProvider::compareByName);

        roster.stream().forEach(System.out::println);

        System.out.println(roster);

        // 引用一个类实例方法，ClassName::MethodName
        // 需求：求花名册中所有人的平均年龄
        double minAge = roster.stream()
                .mapToInt(Person::getAge)
                .min()
                .getAsInt();

        // 引用构造方法
        Person[] people = roster.toArray(Person[]::new);
        System.out.println(Arrays.toString(people));

        // 方法的引用：使得 Lambda 表达式更加的简洁
    }
}
