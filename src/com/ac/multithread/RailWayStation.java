package com.ac.multithread;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <火车站购票场景>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class RailWayStation {
    public static final int NO_TICKET_FLAG = -99999;
    private String name;
    /**
     * 默认有6张票，票号分别是：0,1,2,3,4,5
     */
    private int tickets = 5;
    /**
     * 对象用于同步的锁
     */
    private Object lock = new Object();

    public RailWayStation(String name) {
        this.name = name;
    }

    /**
     * 获取一张票
     * 提供给售票窗口调用的
     *
     * @return 票号
     */
    public int getTickets() {
        // synchronized 关键字，能保证在同一时刻只能由一个线程进入到这个方法
        // synchronized 用于同步，这边是修饰一个方法，同步一个方法
        // synchronized 还可以修饰代码块
        // this 表示当前对象，这边使用到了 this 这个对象的锁
        // 当多线程执行到这里的时候，实际上它们都会去争取拿到 this 这个对象的锁
        // 哪一个线程抢到了锁之后，就有资格进入同步代码块，执行同步代码块
        // 锁可以是任意对象的锁，但是对象要求是全局的对象
        // 说明还有票
        synchronized (lock) {
            // 当线程唤醒之后，需要继续判断一次
            while (tickets < 0) {
                // 当前的买票线程需要等待
                try {
                    // 线程阻塞
                    lock.wait(5000);
                    if(tickets<0){
                        // 没有买到票
                        return NO_TICKET_FLAG;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 模拟出票，睡一会
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 拿到票号
            int ticketNum = tickets--;
            // 返回票号
            return ticketNum;
        }
        // 当线程执行完同步代码块，它会释放拿到的对象锁
    }

    /**
     * 退票的方法
     */
    public void addTicket() {
        // 保护资源，解决并发问题
        synchronized (lock) {
            // 模拟退票
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 增加票号
            // 共同资源，操作共同资源，需要临界区来保护
            tickets++;

            // 通知等待买票的线程进行买票
            lock.notifyAll();
        }
    }
}
