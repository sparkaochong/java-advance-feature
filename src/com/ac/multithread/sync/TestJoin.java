package com.ac.multithread.sync;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class TestJoin {
    public static void main(String[] args) {
        // 同步工具类：CountDownLatch 计数器
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Worker worker1 = new Worker("小明",countDownLatch);
        Worker worker2 = new Worker("小张",countDownLatch);
        Worker worker3 = new Worker("小李",countDownLatch);

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);
        Thread t3 = new Thread(worker3);

        t1.start();
        t2.start();
        t3.start();

        try {
            // 等待 t1 任务完成
            // t1.join();
            // 等待 t2 任务完成
            // t2.join();
            // 等待 t3 任务完成
            // t3.join();
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 要求：三个工人做完了，老板才开始工作

        Boss boss = new Boss("老板");
        new Thread(boss).start();
    }
}
