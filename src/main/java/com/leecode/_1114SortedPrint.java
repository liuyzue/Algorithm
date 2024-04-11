package com.leecode;

import java.util.concurrent.atomic.AtomicInteger;

public class _1114SortedPrint {

    private AtomicInteger atomicIntegerA = new AtomicInteger(0);
    private AtomicInteger atomicIntegerB = new AtomicInteger(0);

    public _1114SortedPrint() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomicIntegerA.set(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomicIntegerA.get() != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        atomicIntegerA.set(0);
        atomicIntegerB.set(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomicIntegerB.get() != 1) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        atomicIntegerB.set(0);
    }
}
