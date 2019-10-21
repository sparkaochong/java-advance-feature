package com.ac.collection.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/16
 *
 * @author aochong
 * @version 1.0
 */
public class TestStreamOperator {
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        // 打印所有男性人的姓名
        for (Person person : roster) {
            if (person.getGender() == Person.Gender.MALE) {
                System.out.println(person.getName());
            }
        }

        System.out.println("-------------------------------------------------------------");

        // 每一次使用 Stram 编程的时候，我们都是构建了一个数据处理的 pipeline
        // 1. 数据源，可以是集合，也可以是数组
        // 2. 零个或者多个中间的操作，将一个类型的 stream 转成另一个 stream，比如 filter、map ...
        // 3. 一个终端操作(最后一个 action操作),输出结果，或者得到结果
        roster.stream()
                .filter(person -> person.getGender() == Person.Gender.MALE)
                .forEach(person -> System.out.println(person.getName()));

        // 数组作为数据源
        int[] arr = new int[]{1, 4, 2, 5, 6, 3, 1};
        // 输出大于3的元素
        Arrays.stream(arr).filter(e -> e > 3).forEach(e -> System.out.println(e));

        System.out.println("-------------------------------------------------------------");


        // map 一个类型转成另一个类型，一对一的关系
        String[] strings = new String[]{
                "this is my first example",
                "The following example calculates",
                "Aggregate operations do not"
        };

        // flatMap 中间的操作
        // flatMap 一个类型转成另一个类型，一对多的关系
        Arrays.stream(strings)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .forEach(element -> System.out.println(element));

        System.out.println("-------------------------------------------------------------");

        Arrays.stream(strings)
                .map(line -> line.split(" "))
                .forEach(element -> System.out.println(Arrays.toString(element)));

        System.out.println("-------------------------------------------------------------");

        // 统计三行数据中心一共有多少个单词
        long count = Arrays.stream(strings)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .count();

        System.out.println(count);

        System.out.println("-------------------------------------------------------------");

        // 统计三行数据中心一共有多少个单词
        long counts = Arrays.stream(strings)
                .map(line -> line.split(" "))
                .mapToInt(r -> r.length)
                .sum();

        System.out.println(counts);

        System.out.println("-------------------------------------------------------------");

        // 将 Stream 转成集合
        List<String> words = Arrays.stream(strings)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.toList());

        System.out.println(words);

        System.out.println("-------------------------------------------------------------");

        // 需求：求花名册中所有人的平均年龄
        double minAge = roster.stream()
                .mapToInt(person -> person.getAge())
                .min()
                .getAsInt();

        System.out.println(minAge);
    }
}
