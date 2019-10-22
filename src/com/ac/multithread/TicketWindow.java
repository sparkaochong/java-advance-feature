package com.ac.multithread;

/**
 * Description:
 * <售票窗口>
 *     每一个售票窗口都是一个线程
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class TicketWindow implements Runnable {
    // 所属火车站
    private RailWayStation railWayStation;

    public TicketWindow(RailWayStation railWayStation){
        this.railWayStation = railWayStation;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在买票");

        // 拿到票号
        int ticketNum = railWayStation.getTickets();
        if(ticketNum==RailWayStation.NO_TICKET_FLAG){
            System.out.println(name + "没有买到票");
        }else{
            System.out.println(name + "买到的票号是：" + ticketNum);
        }
    }
}
