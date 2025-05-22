package com.concurrent;

/**
 * @author liuyuze
 * @date 2025/4/18 15:35
 */
public class VolatileDemo {
    /*
    * 有2个线程，分别顺序打印数组 {1,2,3}、{'a','b','c'}。
    * 设计一个程序，使最终打印顺序为 1 a 2 b 3 c 即两个线程交替打印。
    *
    *
    * */
    //使用volatile关键字保证内存可见性，使一个线程改变值时其他线程也能可见
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
