package com.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuyuze
 * @date 2025/4/16 16:40
 */
public class ConCurrentPrint {

    static volatile int flag = 0;

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            int[] a = {1,2,3};
            int index = 0;
            while (index < a.length) {
                if (flag == 0) {
                    System.out.println(a[index++]);
                    flag = 1;
                }
            }
        }
        );
        Thread thread1 = new Thread(() -> {
            char[] a = {'a','b','c'};
            int index = 0;
            while (index < a.length) {
                if (flag == 1) {
                    System.out.println(a[index++]);
                    flag = 0;
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
