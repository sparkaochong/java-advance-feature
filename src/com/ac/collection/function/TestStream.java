package com.ac.collection.function;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Description:
 * <Stream编程>
 * Created by aochong on 2019/10/16
 *
 * @author aochong
 * @version 1.0
 */
public class TestStream {
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        // 函数式编程

        // 数据源
        Stream<Person> dataSource = roster.stream().filter(person ->
                person.getGender() == Person.Gender.MALE
                        && person.getAge() >= 18
                        && person.getAge() <= 25);
        // 数据过滤
        Stream<Person> filtered = dataSource.filter(person ->
                person.getGender() == Person.Gender.MALE
                        && person.getAge() >= 18
                        && person.getAge() <= 25);

        // 数据转换
        Stream<String> mappered = filtered.map(person -> person.getEmail());
        // 数据消费
        mappered.forEach(email -> System.out.println("发送邮件给：" + email));

        // data process pipeline(数据处理管道)
        // 链式开发
        // 符合义务兵条件的人，并且给他发邮件
        roster.stream()
                .filter(person -> {
                    return person.getGender() == Person.Gender.MALE &&
                            person.getAge() >= 18 &&
                            person.getAge() <= 25;
                })
                .map(person -> person.getEmail())
                .forEach(email -> System.out.println("发送邮件给：" + email));

        // 使用 Stream() 重写具体例子
        List<String> personLines = new ArrayList<>();
        personLines.add("Fred\t1980\t6\t20\tMALE\tfred@example.com");
        personLines.add("Jane\t1990\t7\t15\tFEMALE\tjane@example.com");
        // 脏数据，缺少字段的数据
        personLines.add("Jeffy\t7\t15\tFEMALE\tJeffy@example.com");
        personLines.add("George\t1991\t8\t13\tMALE\tgeorge@example.com");
        personLines.add("Kathy\t7\t15\tKathy@example.com");
        personLines.add("Bob\t2000\t9\t12\tMALE\tbob@example.com");

        Function<String, Person> mapper = line ->{
            String[] fields = line.split("\t");
            int year = Integer.parseInt(fields[1]);
            int month = Integer.parseInt(fields[2]);
            int day = Integer.parseInt(fields[3]);
            LocalDate birthday = IsoChronology.INSTANCE.date(year,month,day);
            return new Person(fields[0],birthday,Person.Gender.valueOf(fields[4]),fields[5]);
        };

        personLines.stream()
                .filter(line -> line.split("\t").length==6)
                .map(mapper)
                .forEach(person -> System.out.println(person));


    }
}
