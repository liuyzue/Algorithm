package com.leecode;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode
 * @date:2020/7/24
 * @time:23:21
 */
public class FibonacciSequence {

    static int[] ints = new int[50];

    /**
     * 普通递归
     * n=39 : 63245986 206 ms
     * n=40 : 102334155 357 ms
     * n=41 : 165580141 578 ms
     * n=42 : 267914296 868 ms
     * n=43 : 433494437 1318 ms
     * n=44 : 701408733 2134 ms
     * n=45 : 1134903170 3451 ms
     */
    public int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 带缓存的递归
     */
    public int fibonacci2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        //如果缓存中已经存在，就从缓存中取
        if (ints[n] > 0) {
            return ints[n];
        }
        //将已经计算过的数据存入缓存中
        int t = fibonacci2(n - 1) + fibonacci2(n - 2);
        ints[n] = t;
        return t;
    }

    /**
     * 非递归
     *
     * @param n
     * @return
     */
    public int fibonacci3(int n) {
        if (n <= 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 求n的阶乘
     * @param n
     * @return
     */
    public int fac(int n){
        if (n <= 1){
            return 1;
        }
        return n*fac(n-1);
    }
    public int tailFac(int res,int n){
        System.out.println(res);
        if (n <= 1){
            return res;
        }
        return tailFac(res*n,n-1);
    }


    /**
     * 尾递归
     * @param n
     * @return
     */
    public int fibonacci4(int res , int last ,int n){
        // 1 1 2 3 5 8 13 21 34
        //System.out.println(res);
        if (n <= 2){
            return res;
        }
        //参数为本次结果和上次结果
        return fibonacci4(res+last ,res ,n-1);
    }
}
