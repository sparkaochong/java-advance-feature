package com.ac.collection.function;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/15
 *
 * @author aochong
 * @version 1.0
 */
public class TestRoster {
    public static void main(String[] args) {
        // 拿到花名册
        List<Person> roster = Person.createRoster();

        // 1. 找年龄大于指定年龄的人，并且打印其信息
        System.out.println("大于20岁的人：");
        printPersonWithPredicate(roster,
                person -> person.getAge()>20 ,
                person -> person.getEmail(),
                (String email) -> System.out.println(email));

        System.out.println("---------------------------------------");

        // 2. 找出年龄在一个指定范围的人，并且打印出来
        System.out.println("在 20 岁到 30 岁之间的人：");
        printPersonWithPredicate(roster,
                person -> person.getAge()>=20 && person.getAge()<=30,
                person -> person.getEmail(),
                (String email) -> System.out.println(email));

        System.out.println("---------------------------------------");

        // 3. 找出年龄在一个指定范围并且是属于指定性别的人，并且打印出来
        // 符合义务兵条件的人
        System.out.println("符合义务兵条件的人：");
        printPersonWithPredicate(roster,
                person -> {
                    return person.getGender() == Person.Gender.MALE &&
                            person.getAge() >= 18 &&
                            person.getAge() <= 25;
                },
                person -> person.getEmail(),
                email -> System.out.println(email));

        // 1. 函数(lambda表达式)作为方法的参数进行传递，函数式编程
        // 2. Java 中的函数(lambda表达式)本质上就是 Java 的接口(只有一个抽象方法)，函数式接口

        // java.util.function.Predicate
    }

    /**
     * 找出年龄大于指定年龄的人，并且打印其信息
     * @param roster 花名册
     * @param age 指定年龄
     */
    public static void printPersonOlderThan(List<Person> roster,int age){
        for(Person person:roster){
            if(person.getAge()>age){
                System.out.println(person);
            }
        }
    }

    /**
     * 找出年龄在一个指定范围的人，并且打印出来
     * @param roster 花名册
     * @param lowAge 最小年龄
     * @param highAge 最大年龄
     */
    public static void printPersonWithinAgeRange(List<Person> roster,int lowAge,int highAge){
        for(Person person: roster){
            if(person.getAge()>lowAge && person.getAge()<highAge){
                System.out.println(person);
            }
        }
    }

    public static void printPersonWithCheck(List<Person> roster,CheckPerson checkPerson){
        for(Person person: roster){
            if(checkPerson.test(person)){
                System.out.println(person);
            }
        }
    }

    public static void printPersonWithPredicate(List<Person> roster,
                                                Predicate<Person> checkPerson, // 条件测试
                                                Function<Person,String> mapper, // 数据转换
                                                Consumer<String> consumer){ // 数据的消费
        for(Person person: roster){
            // 条件测试
            if(checkPerson.test(person)){
                // 对符合条件的人采取一定的措施
                // System.out.println(person);
                // 数据类型转换 -> Person -> String
                String email = mapper.apply(person);
                consumer.accept(email);
            }
        }
    }
}
