package com.ac.multithread;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class TestTicket {
    public static void main(String[] args) {
        RailWayStation railWayStation = new RailWayStation("杭州东站");

        // 创建五个售票窗口
        TicketWindow window1 = new TicketWindow(railWayStation);
        TicketWindow window2 = new TicketWindow(railWayStation);
        TicketWindow window3 = new TicketWindow(railWayStation);
        TicketWindow window4 = new TicketWindow(railWayStation);
        TicketWindow window5 = new TicketWindow(railWayStation);

        // 模拟 8 个人来窗口买票
        new Thread(window1,"用户A").start();
        new Thread(window2,"用户B").start();
        new Thread(window2,"用户C").start();
        new Thread(window3,"用户D").start();
        new Thread(window4,"用户E").start();
        new Thread(window4,"用户F").start();
        new Thread(window5,"用户G").start();
        new Thread(window5,"用户H").start();
        new Thread(window5,"用户I").start();

        // 创建退票窗口
        RefundTicketWindow refundTicketWindow = new RefundTicketWindow(railWayStation);

        // 模拟两个用户退票
        new Thread(refundTicketWindow,"用户甲").start();
        new Thread(refundTicketWindow,"用户乙").start();

    }
}
