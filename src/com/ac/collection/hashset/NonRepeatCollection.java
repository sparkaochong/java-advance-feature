package com.ac.collection.hashset;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Description:
 * <不允许有重复元素的集合>
 * Created by aochong on 2019/10/10
 *
 * @author aochong
 * @version 1.0
 */
public class NonRepeatCollection<E> implements Iterable<E> {
    private HashMap<E, Object> map;
    private static final Object DUMMY_OBJECT = new Object();

    public NonRepeatCollection(){
        map = new HashMap<>();
    }

    public void add(E element){
        // map 中的 key 是不允许有重复的
        map.put(element,DUMMY_OBJECT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public static void main(String[] args) {
        NonRepeatCollection<Integer> collection = new NonRepeatCollection<>();
        collection.add(1);
        collection.add(2);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(4);
        for(Integer integer:collection){
            System.out.print(integer + "、");
        }
    }
}
