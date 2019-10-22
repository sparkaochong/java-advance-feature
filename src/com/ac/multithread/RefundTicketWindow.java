package com.ac.multithread;

/**
 * Description:
 * <退票窗口>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class RefundTicketWindow implements Runnable {
    /**所属火车站*/
    private RailWayStation railWayStation;

    public RefundTicketWindow(RailWayStation railWayStation){
        this.railWayStation = railWayStation;
    }

    @Override
    public void run() {
        // 退票：将票号退还给火车站
        railWayStation.addTicket();
    }
}
