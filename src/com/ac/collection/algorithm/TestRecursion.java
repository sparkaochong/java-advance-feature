package com.ac.collection.algorithm;

/**
 * Description:
 * <递归>
 * Created by aochong on 2019/10/14
 *
 * @author aochong
 * @version 1.0
 */
public class TestRecursion {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
        System.out.println(walkStair(5));
    }

    /**
     * 走 n 个台阶的走法，每次只能走一个台阶或者两个台阶
     * @param n
     * @return
     */
    public static int walkStair(int n){
        if(n==1)return 1;
        if(n==2)return 2;
        return walkStair(n-1) + walkStair(n-2);
    }

    /**
     * 求第 n 个斐波那契数
     * @param n
     * @return
     */
    public static int fibonacci(int n){
        // 2. 终止条件
        if(n==1 || n==2) return 1;
        // 1. 递推公式
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int f(int n){
        if(n==1){
            return 1;
        }
        // 递归调用本方法
        return f(n-1) + 1;
    }
}
