package com.concurrent;

/**
 * @author liuyuze
 * @date 2025/4/18 15:45
 */
public class WaitNotifyDemo {

    public final static Object locker1 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            int[] a = {1, 2, 3};
            int index = 0;
            for (int i = 0; i < a.length; i++) {
                if (i == 1) {
                    synchronized (locker1) {
                        try {
                            //使用wait必须要在synchronized代码块中，且锁对象和wait对象必须为同一个
                            locker1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                System.out.println(a[index++]);
            }

        });

        Thread thread2 = new Thread(() -> {
            int[] a = {4, 5, 6};
            int index = 0;
            for (int i = 0; i < a.length; i++) {
                if (i == 1) {
                    synchronized (locker1) {
                        try {
                            //使用wait必须要在synchronized代码块中，且锁对象和wait对象必须为同一个
                            locker1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                System.out.println(a[index++]);
            }

        });

       thread1.start();
       thread2.start();
       Thread.sleep(1000);
       synchronized (locker1) {
           //notify/notifyAll使用时也必须在synchronized代码块中，且锁对象和notify对象为同一个
           //一般情况下更推荐使用notifyAll唤醒所有等待线程，因为使用notify会随机唤醒一个线程，可能无法唤醒期望的线程
           //"notify" may not wake up the appropriate thread.
           // locker1.notify();
           locker1.notifyAll();
       }

    }
}
