package com.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liuyuze
 * @date 2025/4/18 16:24
 */
public class LockSupportParkUnParkDemo {

    private final static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
           int[] a = {1, 2, 3, 4, 5, 6};
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
                if (i == 3) {
                    //使用juc包中的静态方法LockSupport.park()使当前线程暂停运行，当有其他线程调用LockSupport.unpark(当前线程对象)时，对该对象发放【许可】,获得并使用许可后继续运行
                    LockSupport.park();
                    // LockSupport.park(locker);
                }
            }
        });
        thread.start();
        //如果在thread运行后，先给线程发放【许可】，那么线程将不会阻塞
        LockSupport.unpark(thread);
        Thread.sleep(2000);
        //给线程发放【许可】
        LockSupport.unpark(thread);
    }
}
