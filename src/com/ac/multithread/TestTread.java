package com.ac.multithread;

/**
 * Description:
 * <线程>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
class FiveNumberPrinter extends Thread{

    /**
     * 通过构造方法设置线程的名字
     * @param threadName
     */
    public FiveNumberPrinter(String threadName){
        super(threadName);
    }

    /**
     * 可以重写或者覆写 Thread 中的 run 方法
     * 这个方法中，放的就是这个线程需要执行的代码
     * 在 run 方法中执行的程序，我们也可以叫做任务(task)
     */
    @Override
    public void run() {
        // 当前这个线程的任务(task)
        for(int i=0;i<5;i++){
            // 让当前的线程睡觉1秒钟
            // 这个时候当前的线程发生了阻塞，进入了阻塞的状态
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
/**
 * @author aochong
 */
public class TestTread {
    public static void main(String[] args) {
        // 程序都是运行在单个线程中的，线程的名字是 main 线程
        // 拿到当前线程的名称
        System.out.println(Thread.currentThread().getName());

        FiveNumberPrinter printer1 = new FiveNumberPrinter("线程一");
        // 将线程设置为守护线程
        //printer1.setDaemon(true);


        // windows系统：优先级必须在 1~10 之内
        // linux系统：优先级没用
        // 设置成优先级最高的线程
        printer1.setPriority(Thread.MAX_PRIORITY);
        FiveNumberPrinter printer2 = new FiveNumberPrinter("线程二");
        // 将线程设置为守护线程
        //printer2.setDaemon(true);

        // 设置成优先级中等的线程
        printer2.setPriority(Thread.NORM_PRIORITY);
        FiveNumberPrinter printer3 = new FiveNumberPrinter("线程三");
        // 将线程设置为守护线程
        //printer3.setDaemon(true);

        // 设置成优先级最低的线程
        printer3.setPriority(Thread.MIN_PRIORITY);

        // 启动三个线程
        printer1.start();
        printer2.start();
        printer3.start();

        // 让当前的线程(main线程)睡觉1秒钟
        // 这个时候当前的线程发生了阻塞，进入了阻塞的状态
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        // 当 main 线程运行到这的时候，main 线程结束了
        // 当 JVM 进程中只剩下守护线程的话，那么 JVM 进程将直接退出，不执行守护线程
        System.out.println(Thread.currentThread().getName());
    }
}
