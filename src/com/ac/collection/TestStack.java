package com.ac.collection;

import java.util.Stack;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/14
 *
 * @author aochong
 * @version 1.0
 */
public class TestStack {
    public static void main(String[] args) {
        // 栈，线性结构
        Stack<String> stack = new Stack<>();

        // 栈包含了栈顶 和 栈底
        // 入栈(压栈)
        stack.push("hello");

        System.out.println(stack);

        stack.push("world");

        System.out.println(stack);

        // 出栈
        String element = stack.pop();


        // 压栈
        stack.push("Good");
        stack.push("Day");

        // 出栈
        element = stack.pop();

        // 栈的特点：先进后出(后进先出)

        // 出栈
        element = stack.pop();

        // 出栈
        element = stack.pop();

        // 出栈，栈是空的话出栈抛异常：Exception in thread "main" java.util.EmptyStackException
        element = stack.pop();

        System.out.println("出栈的元素：" + element);
        System.out.println(stack);
    }
}
