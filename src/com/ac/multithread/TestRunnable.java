package com.ac.multithread;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
class PrinterRunnable implements Runnable{
    @Override
    public void run() {
        // 当前这个线程的任务(task)
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
/**
 * @author aochong
 */
public class TestRunnable {
    public static void main(String[] args) {
        PrinterRunnable task = new PrinterRunnable();
        Thread t1 = new Thread(task,"线程一");
        Thread t2 = new Thread(task,"线程二");
        Thread t3 = new Thread(task,"线程三");

        // 启动三个线程
        t1.start();
        t2.start();
        t3.start();

        // 我们可以将任务封装到 Runnable 的子类中的 run 方法中
        // 线程的创建和启动最终还是通过 java.lang.Thread 类来实现，只不过线程要执行的任务，可以放在：
        // 1. Thread 的子类中的 run 方法中
        // 2. 我们可以将任务封装到 Runnable 的子类中的 run 方法中

    }
}
