package com.ac.multithread.pc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class FoodWindow {
    private Queue<Food> foods = new LinkedList<>();

    /**
     * 放菜
     * @param food
     */
    public synchronized void pushFood(Food food){
        // 最多只能放 5 个菜
        while(this.foods.size()==5){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        // 上菜
        this.foods.add(food);

        // 通知等待的服务员上菜
        this.notifyAll();
    }

    /**
     * 取菜
     * @return
     */
    public synchronized Food getFood(){
        // 放菜窗口没有菜
        while(this.foods.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 等待需要上的菜，会从队列中删除
        Food f = this.foods.poll();

        // 通知厨师菜盘子空了
        this.notifyAll();

        // 服务员端菜
        return f;
    }
}
