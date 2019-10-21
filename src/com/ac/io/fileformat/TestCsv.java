package com.ac.io.fileformat;

import com.ac.io.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <CSV文件读取写入>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class TestCsv {
    public static final String[] FILE_HEADER = {"name","year","month","day","gender","emailAddress"};

    public static void main(String[] args) {
        // readPersonCSV();
        // writePersonCsv();
        // readCsvWithApacheCommons();
        writeWithApacheCommons();
    }

    /**
     * 使用 apache commons csv 写入文件
     */
    private static void writeWithApacheCommons(){
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("." + File.separator + "data" + File.separator + "person_apache_commons.csv"))) {
            List<Person> roster = Person.createRoster();
            // 1. 拿到解析 CSV 的格式
            CSVFormat csvFormat = CSVFormat.newFormat('|').withHeader(FILE_HEADER);
            // 2. 构建一个 CSV 打印器，写 CSV 数据的
            CSVPrinter csvPrinter = csvFormat.print(writer);

            for (Person person:roster){
                // 将 Person 中的属性的值转成 String 类型的集合
                List<String> fields = new ArrayList<>();
                fields.add(person.getName());
                fields.add(String.valueOf(person.getBirthday().getYear()));
                fields.add(String.valueOf(person.getBirthday().getMonth()));
                fields.add(String.valueOf(person.getBirthday().getDayOfMonth()));
                fields.add(person.getGender().toString());
                fields.add(person.getEmail());
                // 写一行记录
                csvPrinter.printRecords(fields);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用 apache commons csv 读取并解析文件内容
     */
    private static void readCsvWithApacheCommons(){
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("." + File.separator + "data" + File.separator + "person_new.csv"))) {
            // 1. 拿到解析 CSV 的格式
            Iterable<CSVRecord> records = CSVFormat.newFormat('\t').withFirstRecordAsHeader().parse(reader);

            List<Person> people = new ArrayList<>();
            // 2. 通过解析格式解析 CSV 文件内容
            // String line -> CSVRecord
            for (CSVRecord record:records){
                // CSVRecord -> Person
                String name = record.get("name");
                int year = Integer.parseInt(record.get("year"));
                int month = Integer.parseInt(record.get("month"));
                int day = Integer.parseInt(record.get("day"));

                LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);
                Person.Gender sex = Person.Gender.valueOf(record.get("gender"));
                String emailAddress = record.get("emailAddress");
                Person person = new Person(name, birthday, sex, emailAddress);
                people.add(person);
            }
            System.out.println(people);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 将Person 类型的对象转成CSV文件格式的数据，并保存
     */
    private static void writePersonCsv() {
        List<Person> roster = Person.createRoster();
        // 将花名册以CSV文件格式保存到 person_new.csv 这个文件中
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("." + File.separator + "data" + File.separator + "person_new.csv"))) {
            // 定义分隔符
            String separator = "\t";
            // 写入 CSV 头(head)
            writer.write("name" + separator + "year" + separator + "month" + separator
                    + "day" + separator + "gender" + separator + "emailAddress");
            writer.newLine();
            for (Person person : roster) {
                // Person 类型的对象 --> String类型的line
                StringBuilder sb = new StringBuilder();
                sb.append(person.getName());
                sb.append(separator);
                sb.append(person.getBirthday().getYear());
                sb.append(separator);
                sb.append(person.getBirthday().getMonth().getValue());
                sb.append(separator);
                sb.append(person.getBirthday().getDayOfMonth());
                sb.append(separator);
                sb.append(person.getGender().toString());
                sb.append(separator);
                sb.append(person.getEmail());

                String line = sb.toString();
                // 将一行的数据写入到文件当中
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * CSV文件内容的读取与解析
     * line -> Person
     */
    public static void readPersonCSV() {
        try (BufferedReader read =
                     new BufferedReader(new FileReader("." + File.separator + "data" + File.separator + "person.csv"))) {
            String line = null;
            List<Person> people = new ArrayList<>();
            while ((line = read.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int year = Integer.parseInt(fields[1]);
                int month = Integer.parseInt(fields[2]);
                int day = Integer.parseInt(fields[3]);

                LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);
                Person.Gender sex = Person.Gender.valueOf(fields[4]);
                String emailAddress = fields[5];
                Person person = new Person(name, birthday, sex, emailAddress);
                people.add(person);
            }
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
