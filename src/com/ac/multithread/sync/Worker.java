package com.ac.multithread.sync;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class Worker implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;
    private CyclicBarrier cyclicBarrier;

    public Worker(String name,CyclicBarrier cyclicBarrier){
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    public Worker(String name,CountDownLatch countDownLatch){
        this.name = name ;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(name + " 第一阶段开始工作");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 第一阶段工作完成");

        // 计数器 -1
        // countDownLatch.countDown();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(name + " 第二阶段开始工作");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 第二阶段工作完成");
    }
}
