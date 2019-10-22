package com.ac.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:
 * <通过实现 java.util.concurrent.Callable接口，来封装一个线程需要执行的任务>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
class SumTask implements Callable<Integer>{
    /**开始数字*/
    private int startNum;
    /**结束数字*/
    private int endNum;

    public SumTask(int startNum,int endNum){
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        int result = 0;
        for(int i=startNum;i<=endNum;i++){
            result += i;
        }
        return result;
    }
}
/**
 * @author aochong
 */
public class TestCallable {
    public static void main(String[] args) {
        // 第一个线程需要做的事情：1~999 的和
        SumTask task1 = new SumTask(1,999);
        // 需要将 Callable 的子类包装转换成 FutureTask
        // FutureTask 是 java.lang.Runnable 的子类
        FutureTask<Integer> futureTask1 = new FutureTask<>(task1);
        Thread t1 = new Thread(futureTask1);
        t1.start();

        // 第二个线程需要做的事情：1000~9999 的和
        SumTask task2 = new SumTask(1000,9999);
        FutureTask<Integer> futureTask2 = new FutureTask<>(task2);
        Thread t2 = new Thread(futureTask2);
        t2.start();

        // 第三个线程需要做的事情：10000~99999 的和
        SumTask task3 = new SumTask(10000,99999);
        FutureTask<Integer> futureTask3 = new FutureTask<>(task3);
        Thread t3 = new Thread(futureTask3);
        t3.start();

        // 在 main 线程中拿到三个线程计算的结果
        try {
            int result1 = futureTask1.get();
            int result2 = futureTask2.get();
            int result3 = futureTask3.get();
            System.out.println("第一个线程的结果：" + result1);
            System.out.println("第二个线程的结果：" + result2);
            System.out.println("第三个线程的结果：" + result3);
            System.out.println("结果：" + (result1 + result2 + result3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
