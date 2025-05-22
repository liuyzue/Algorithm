package com.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author liuyuze
 * @date 2025/4/17 13:58
 */
public class YieldDemo {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            int[] a = {1,2,3,4,5};
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
                //每次循环都会让当前线程释放CPU资源，让其他线程有机会执行
                Thread.yield();
                //使用sleep(0)的方法和使用yield的效果相同
                /*try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/

            }
            System.out.println("1 finished");
        });

        Thread thread2 = new Thread(() -> {
            char[] c = {'a','b','c','d','e'};
            for (int i = 0; i < c.length; i++) {
                System.out.println(c[i]);
            }
            System.out.println("2 finished");
        });

        //因为测试逻辑简单，不使用yield大多数情况下会是thread1执行完后thread2才开始执行，如果在thread1线程中使用yield，则会一定程度上提高两个线程穿插执行的几率
        thread1.start();
        thread2.start();
        System.out.println("main finished");
    }
}
