package com.ac.multithread.pc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class Chef implements Runnable {
    /**放菜窗口*/
    private BlockingQueue<Food> foodWindow;
    /**拿手的菜*/
    private Food handyFood;

    private String name;

    public Chef(BlockingQueue<Food> foodWindow,Food handyFood,String name){
        this.foodWindow = foodWindow;
        this.handyFood = handyFood;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + ": " + "开始做菜！");

        // 做菜
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + ": " + handyFood + " 已做好");
        // 将菜放到窗口
        foodWindow.add(handyFood);
    }
}
