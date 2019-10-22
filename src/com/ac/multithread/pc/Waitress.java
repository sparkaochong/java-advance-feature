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
public class Waitress implements Runnable {
    /**取菜窗口*/
    private BlockingQueue<Food> foodWindow;

    private String name;

    public Waitress(BlockingQueue<Food> foodWindow,String name){
        this.foodWindow = foodWindow;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            // 端菜
            Food food = null;
            try {
                food = this.foodWindow.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + "上菜：" + food.getName());

            // 上菜
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
