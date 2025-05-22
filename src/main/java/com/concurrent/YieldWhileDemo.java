package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuyuze
 * @date 2025/4/17 14:18
 */
public class YieldWhileDemo {

    public static void main(String[] args) {

        final int[] i = {0};

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i[0] = 1;
        });

        thread.start();
        while (true)  {
            if (i[0] == 1) {
                break;
            }
            //如果不使用yield，主线程会一直执行，其他线程很难争抢到cpu
            //使用yield增大其他线程执行的概率
            Thread.yield();
        }
    }
}
