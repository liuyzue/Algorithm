package com.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liuyuze
 * @date 2025/4/18 23:10
 */
public class FutureTaskDemo {

    public static void main(String[] args) {

        Callable<String> callable = () -> {
            Thread.sleep(5000);
            //主线程调用cancel方法时,如果参数为true则不会打印
            System.out.println("task run done");

            //callable接口支持异常抛出
            try {
                int i = 10 / 0;
            } catch (RuntimeException e) {
                throw e;
            }
            return "call back";
        };

        FutureTask<String> future = new FutureTask<>(callable);

        // futureTask也需要作为参数放到Thread类中start来启动任务
        new Thread(future).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //cancel取消任务执行,参数为true标识将子任务线程的中断标识设置为true,false则表示不中断
        // future.cancel(true);
        boolean cancelled = future.isCancelled();
        if (cancelled) {
            System.out.println("task is cancelled");
        } else {
            System.out.println("task is not cancelled");
        }
        // 即使任务被cancel了,isDone方法还是会返回true
        boolean done = future.isDone();
        if (done) {
            System.out.println("task is done");
        } else {
            System.out.println("task is running");
        }

        //get方法阻塞主线,直到任务完成
        String x = null;
        //主线程可以捕捉到子线程的执行异常
        try {
            x = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(x);

    }
}
