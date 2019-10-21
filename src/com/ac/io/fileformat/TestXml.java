package com.ac.io.fileformat;

import com.ac.io.Person;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class TestXml {
    public static void main(String[] args) {
        readXmlWithDom4j();
        // writeXmlWithDom4j();
    }

    /**
     * XML 文件的写入
     */
    private static void writeXmlWithDom4j(){
        List<Person> roster = Person.createRoster();
        // 将花名册以 XML 的格式写入保存到 person_new.xml
        try(FileWriter writer =
                new FileWriter("." + File.separator + "data" + File.separator + "person_new.xml")){
            // 构造一个 XML Document 文档
            Document document = DocumentHelper.createDocument();
            // 文档下面的所有元素的构造
            Element root = document.addElement("persons");
            for(Person person:roster){
                Element personElement = root.addElement("person");

                personElement.addElement("name").addText(person.getName());
                Element birthdayElement = personElement.addElement("birthday");
                birthdayElement.addElement("year").addText(String.valueOf(person.getBirthday().getYear()));
                birthdayElement.addElement("month").addText(String.valueOf(person.getBirthday().getMonth().getValue()));
                birthdayElement.addElement("day").addText(String.valueOf(person.getBirthday().getDayOfMonth()));

                personElement.addElement("gender").addText(person.getGender().toString());
                personElement.addElement("email").addText(person.getEmail());
            }
            document.write(writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * XML 文件的读取和解析
     */
    private static void readXmlWithDom4j(){
        try(BufferedReader reader =
                new BufferedReader(new FileReader("." + File.separator + "data" + File.separator + "person_new.xml"))){
            List<Person> people = Person.createRoster();
            // 构建一个 XML 读取的实例
            SAXReader saxReader = new SAXReader();
            // 转成 Document
            Document document = saxReader.read(reader);
            // 拿到 XML 的根元素
            Element rootElement = document.getRootElement();
            // 遍历所有的 person 标签
            Iterator<Element> elementIterator = rootElement.elementIterator();
            while(elementIterator.hasNext()){
                Element element = elementIterator.next();
                // 将一个 Element -> Person 对象
                String name = element.elementText("name");
                Element birthdayElement = element.element("birthday");
                int year = Integer.parseInt(birthdayElement.elementText("year"));
                int month = Integer.parseInt(birthdayElement.elementText("month"));
                int day = Integer.parseInt(birthdayElement.elementText("day"));

                LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);
                Person.Gender sex = Person.Gender.valueOf(element.elementText("gender"));
                String emailAddress = element.elementText("email");
                Person person = new Person(name, birthday, sex, emailAddress);
                people.add(person);
            }
            System.out.println(people);
        }catch (IOException | DocumentException e){
            e.printStackTrace();
        }
    }
}
