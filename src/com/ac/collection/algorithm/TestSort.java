package com.ac.collection.algorithm;

import com.ac.collection.Person;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/14
 *
 * @author aochong
 * @version 1.0
 */

class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge()>o2.getAge())return 1;
        if(o1.getAge()<o2.getAge())return -1;
        return 0;
    }
}
/**
 * @author aochong
 */
public class TestSort {
    public static void main(String[] args) {
        long[] arr = new long[]{11,8,3,9,7,1,2,5};

        PrimitiveTypeSortUtil.quickSort(arr);
        System.out.println(Arrays.toString(arr));

        Person[] people = new Person[5];
        people[0] = new Person("a",20);
        people[1] = new Person("h",24);
        people[2] = new Person("t",26);
        people[3] = new Person("b",19);
        people[4] = new Person("d",18);

        String[] strings = new String[]{"d","t","y","b","a","c"};

        // 要求给 people 按照年龄排序
        // 1. 使用比较器来比较人
        // ComparatorSortUtil.insertionSort(strings, (s1, s2) -> s1.compareTo(s2));

        // 直接使用 JAVA 提供的方法就可以了
        /*Arrays.sort(people, (o1,o2) -> {
           if(o1.getAge()>o2.getAge())return 1;
           if(o1.getAge()<o2.getAge())return -1;
           return 0;
        });*/

        // Arrays.sort(strings, (o1,o2) -> o1.compareTo(o2));

        Arrays.sort(people);
        System.out.println(Arrays.toString(people));

        // 2. 使用 java.util.Comparable 来比较
        ComparableSortUtil.mergeSort(strings);
        System.out.println(Arrays.toString(strings));

        Integer[] arr1 = new Integer[]{11,8,3,9,7,1,2,5};
        Arrays.sort(arr1,(Integer o1,Integer o2) -> -o1.compareTo(o2));
        System.out.println(Arrays.toString(arr1));

        // Arrays.sort() 大部分使用快速排序
    }
}
