package com.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
/**
 * @author liuyuze
 * @date 2025/4/20 16:15
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //CompletableFuture本身提供了2个静态方法用于创建异步任务
        // runAsync 运行任务（无返回值） /supplyAsync 生产者任务（有返回值）
        //每个方法都有2个实现，1.单个参数仅传入任务体  2.两个参数 任务体 + 线程池 用于选择使用哪个线程池执行任务，如果不传入，cpu数量 > 2时默认使用ForkJoin线程池，< 2时直接new Thread执行
        CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello";
        });

        //使用thenApplyAsync编排持续任务，使用当前任务的返回值作为参数，继续执行其他任务
        CompletableFuture<String> thenApply = supplyAsync1.thenApplyAsync((str) -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return str + "world";
        });

        //thenAccept来消费当前任务的执行结果，无返回值
        CompletableFuture<Void> voidCompletableFuture = supplyAsync1.thenAccept((str) -> {
            System.out.println(str);
        });

        System.out.println(voidCompletableFuture.get());
        System.out.println(thenApply.get());

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task1 done");
            return "task1";
        });
        // whenComplete方法用于处理任务结束后对结果及异常进行处理
        task1.whenComplete((str, t) -> {

        });
        //exceptionally专门用于处理任务的异常
        CompletableFuture<String> exceptionally = task1.exceptionally((t) -> {
            t.printStackTrace();
            return "异常情况" + t.getMessage();
        });
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("task2 done");
            return "task1";
        });
        //allOf/anyOf方法同样是CompletableFuture提供的静态方法，allOf用于等待传入的所有任务都结束才返回，anyOf用于其中某一个任务完成即返回。
        // CompletableFuture.allOf(task1,task2).get();
        CompletableFuture.anyOf(task1,task2).get();

        //除了以上案例 CompletableFuture还提供了很多其他任务编排方法
        // 1.结果组合thenCombine合并两个任务结果一并处理
        // 2.applyToEither两个任务相比，处理先执行完成的结果,并返回结果
        // 3.acceptEither 两个任务相比，处理先获得的执行结果，不返回结果
        // ......

    }
}
