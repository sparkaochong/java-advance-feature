package com.ac.io;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Description:
 * <序列化机制与反序列化机制>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class TestObjectIo {
    public static void main(String[] args) {
        // 如果一个类需要序列化的话，那么它需要实现 java.io.Serializable 这个标识接口
        // 如果这个类中有些属性不需要进行序列化的话，我们使用关键字 transient 来修饰
        // 我们还可也自定义方法 writeObject 和 readObject

        String path = "." + File.separator + "data" + File.separator + "person.txt";
        List<Person> roster =  Person.createRoster();

        // 数据在磁盘文件中是以二进制的方式存储
        // 对象 装换成 二进制 的过程，这个过程我们称之为对象的序列化
        try (ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(path))) {
            for(Person person: roster){
                objectOutputStream.writeObject(person);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //
        try(ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(path))) {
            Object o = null;
            while(true){
                try {
                    o = objectInputStream.readObject();
                }catch (EOFException e){
                    break;
                }
                Person person = (Person) o;
                System.out.println(person);
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
