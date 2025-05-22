package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuyuze
 * @date 2025/4/20 21:48
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    private AtomicInteger index = new AtomicInteger(0);
    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5 ;i ++) {
            int count = i;
            // executorService.submit(new Runnable() {
            //     @Override
            //     public void run() {
            //         local.set(count);
            //         // System.out.println("count:" + count + "  第" + local.get() + "个线程被创建");
            //         System.out.println("count:" + count + "  第" + count + "个线程被创建");
            //     }
            // });
            Thread thread = new Thread(() -> {
                System.out.println(count + "   " + Thread.currentThread().getName());
            });

            thread.setName(i + "thread");
            thread.start();
        }

        // executorService.shutdown();
    }
}
