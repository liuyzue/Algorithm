package com.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author liuyuze
 * @date 2025/4/17 13:46
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread joinThread = new Thread(() -> {
            try {
                //主线程join指定时间时，如果没有在指定时间内完成，主线程将会继续执行
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int[] a = {1,2,3,4,5};
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
            System.out.println("join finished");
        });

        joinThread.start();
        char[] c = {'a','b','c','d','e'};
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
            //调用join方法 让主线程等待子线程执行完毕在继续执行
            if (i == 2) {
                // joinThread.join();
                //指定等待时间,如果指定时间内子线程未执行完，主线程也继续执行
                joinThread.join(1000);
            }
        }
        System.out.println("main finished");

    }
}
