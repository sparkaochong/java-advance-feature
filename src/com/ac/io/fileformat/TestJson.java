package com.ac.io.fileformat;

import com.ac.io.Person;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class TestJson {
    public static void main(String[] args) {
        // JSON -> Java 对象
        // readJson();
        // readPersonJson();

        // Java 对象 转成 Json 字符串
        toJsonString();
    }

    private static void toJsonString(){
        Group group = new Group();
        group.setId(0);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        // group -> json

        String jsonStr = JSON.toJSONString(group);
        System.out.println(jsonStr);
    }

    private static void readPersonJson(){
        String personJson = getJsonString("." + File.separator + "data" + File.separator + "person.json");

        // json -> List<Person>

        // List<Person> people = JSON.parseArray(personJson, Person.class);
        JSONArray jsonArray = JSON.parseArray(personJson);
        jsonArray.stream().map(obj -> {
            // Object -> Person
            JSONObject jsonObject = (JSONObject) obj;
            String name = jsonObject.getString("name");
            int year = jsonObject.getIntValue("year");
            int month = jsonObject.getIntValue("month");
            int day = jsonObject.getIntValue("day");
            LocalDate birthday = IsoChronology.INSTANCE.date(year,month,day);
            Person.Gender sex = Person.Gender.valueOf(jsonObject.getString("gender"));
            String email = jsonObject.getString("email");
            Person person = new Person(name,birthday,sex,email);
            return person;
        }).forEach(System.out::println);
    }

    private static void readJson(){
        String userJson = getJsonString("." + File.separator + "data" + File.separator + "group_user.json");

        // json -> User 对象
        /*JSONObject obj = JSON.parseObject(userJson);
        System.out.println(obj);

        User user = new User();
        user.setName(obj.getString("name"));
        user.setAge(obj.getIntValue("age"));
        user.setId(obj.getIntValue("id"));
        System.out.println(user);*/

        // 通过反射设置对象的属性值
        // 解析一个对象的话，使用 parseObject
        // User user = JSON.parseObject(userJson,User.class);

        // 解析一个列表(数组)
        List<Group> groups = JSON.parseArray(userJson, Group.class);

        System.out.println(groups);
    }

    private static String getJsonString(String filePath) {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader =
                    new BufferedReader(new FileReader(filePath))){
            String line = null;
            while((line = reader.readLine())!=null){
                sb.append(line.trim());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return sb.toString();
    }
}
