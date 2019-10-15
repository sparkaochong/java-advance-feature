package com.ac.collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/14
 *
 * @author aochong
 * @version 1.0
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 队列包含 队首和队尾
        queue.add(10);
        queue.add(20);

        System.out.println("队列中的元素：" + queue);

        Integer element = queue.remove();
        System.out.println("出队的元素：" + element);
        System.out.println("队列中的元素：" + queue);

        // 入队
        queue.add(30);
        System.out.println("队列中的元素：" + queue);

        element = queue.remove();
        System.out.println("出队的元素：" + element);
        System.out.println("队列中的元素：" + queue);

        element = queue.remove();
        System.out.println("出队的元素：" + element);
        System.out.println("队列中的元素：" + queue);

        // 队空的队列进行 remove() 的话，抛出： Exception in thread "main" java.util.NoSuchElementException
        element = queue.remove();
        System.out.println("出队的元素：" + element);
        System.out.println("队列中的元素：" + queue);
    }
}
