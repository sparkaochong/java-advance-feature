package com.ac.collection.hashtable;

import com.ac.collection.College;
import com.ac.collection.Course;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/9
 *
 * @author aochong
 * @version 1.0
 */
public class TestMap {
    public static void main(String[] args) {
        College college = new College("xx计算机学院");

        // 设置课程
        Map<String, Course> coursesmMap = new HashMap<>();
        // 初始化课程
        coursesmMap.put("高数", new Course(1, "高数", 6));
        coursesmMap.put("Java程序开发", new Course(2, "Java程序开发", 10));
        coursesmMap.put("操作系统", new Course(3, "操作系统", 9));
        coursesmMap.put("思想政治", new Course(4, "思想政治", 5));
        coursesmMap.put("英语", new Course(5, "英语", 10));
        coursesmMap.put("C语言", new Course(6, "C语言", 10));
        coursesmMap.put("体育", new Course(7, "体育", 2));
        coursesmMap.put("编译原理", new Course(8, "编译原理", 7));
        coursesmMap.put("概率统计", new Course(9, "概率统计", 5));
        coursesmMap.put("计算机网络", new Course(10, "计算机网络", 6));
        coursesmMap.put("线性代数", new Course(11, "线性代数", 5));
        coursesmMap.put("电子电路原理", new Course(12, "电子电路原理", 2));
        // 给计算机学院设置课程
        college.setCourseMap(coursesmMap);

        // 拿到学院里面所有的课程
        Map<String,Course> map = college.getCourseMap();

        // 1. 查询API
        // 判断一个 HashMap 是否为空
        boolean isEmpty = map.isEmpty();
        System.out.println(isEmpty);

        // 拿到 map 的长度
        System.out.println("课程的数量：" + map.size());

        // 根据 key 拿到对应的 value
        Course course = map.getOrDefault("kkhjgkj",
                new Course(999,"无名课",100));
        System.out.println(course);

        // 不管你使用 containsKey 还是使用 containsValue ，key 和 value 对应的类必须重写 equals 方法
        // 判断 map 中是否包含指定的 key --> containsKey
        boolean isExists = map.containsKey("高数");
        System.out.println(isExists);

        // 判断 map 中是否包含指定的 value --> containsValue
        // containsValue 是依赖 equals 进行比较
        Course course1 = new Course(4, "思想政治", 5);
        isExists = map.containsValue(course1);
        System.out.println(isExists);

        // 2. 修改API
        // 往 Map 中添加一个键值对
        Course newCourse = new Course(13,"大数据入门",23);
        newCourse = map.put("大数据入门",newCourse);

        System.out.println(map.get("大数据入门"));

        // putIfAbsent() 如果 Map 中已经存在了 key ，就不进行 put，否则就进行 put 操作
        newCourse = new Course(6,"C语言",90);
        map.putIfAbsent("C语言-2",newCourse);
        // put() 当 map 中已经存在 key 的情况下，put() 充当修改API使用，修改对应 key 的 value 的值
        map.put("C语言",newCourse);

        System.out.println(map.get("C语言"));

        // 指定 key 从 map 中删除键值对
        map.remove("C语言");
        System.out.println(map.get("C语言"));

        map.remove("高数", new Course(1, "高数", 6));
        System.out.println(map.get("高数"));

    }
}
