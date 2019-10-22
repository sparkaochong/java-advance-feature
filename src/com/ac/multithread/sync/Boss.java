package com.ac.multithread.sync;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/22
 *
 * @author aochong
 * @version 1.0
 */
public class Boss implements Runnable {
    private String name;

    public Boss(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + " 开始检查工作");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 检查工作完成");
    }
}
