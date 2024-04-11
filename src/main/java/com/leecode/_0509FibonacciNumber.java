package com.leecode;

public class _0509FibonacciNumber {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 1;
        int lastOne = 0;
        int lastTwo = 0;
        for (int i = 1 ; i < n; i++) {
            lastTwo = lastOne;
            lastOne = result;
            result = lastTwo + lastOne;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = fib1(30);
        System.out.println(i);
    }
}
