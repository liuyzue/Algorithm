package com.concurrent;

/**
 * @author liuyuze
 * @date 2025/4/17 21:29
 */
public class InterruptDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    //如果线程正处于sleep/wait/join状态，此时调用interrupt方法，会抛异常并且重新将中断标识置为false
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("thread1 interrupted");
                    //如果不加break会看到即使线程状态已经是 interrupted了，但是线程还在继续执行
                    break;
                }
            }
        }, "thread1");

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            //interrupt方法会把线程的中断标识设置成
            thread.interrupt();
            if (thread.isInterrupted()) {
                System.out.println("thread is interrupt");
            } else {
                System.out.println("interrupt fail");
            }
         }, "thread2");


        thread.start();
        thread1.start();

        try {
            Thread.sleep(5000);
            System.out.println("main stop");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
