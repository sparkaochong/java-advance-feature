package com.ac.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class TestThreadPool {
    public static void main(String[] args) {
        // 使用 java.util.concurrent.Executors 中的静态方法创建线程池
        // newFixedThreadPool：可以指定线程池中有多少个线程
        // newSingleThreadExecutor：线程池中只会有一个线程
        // newCachedThreadPool：主要是为了节省创建线程的时间
        // 如果线程池中有线程的话，那么直接使用，如果没有线程的话，那么就创建，创建完后肯定是放在线程池中
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 第一个线程需要做的事情：1~999 的和
        SumTask task1 = new SumTask(1,999);
        // 向线程池中提交一个任务
        Future<Integer> future1 = executorService.submit(task1);
        // 第二个线程需要做的事情：1000~9999 的和
        SumTask task2 = new SumTask(1000,9999);
        Future<Integer> future2 = executorService.submit(task2);
        // 第三个线程需要做的事情：10000~99999 的和
        SumTask task3 = new SumTask(10000,99999);
        Future<Integer> future3 = executorService.submit(task3);

        // 拿到线程执行的返回值
        try {
            int result1 = future1.get();
            int result2 = future2.get();
            int result3 = future3.get();
            System.out.println("第一个线程的结果：" + result1);
            System.out.println("第二个线程的结果：" + result2);
            System.out.println("第三个线程的结果：" + result3);
            System.out.println("结果：" + (result1 + result2 + result3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.submit(new FiveNumberPrinter("线程一"));

        executorService.shutdown();
    }
}
