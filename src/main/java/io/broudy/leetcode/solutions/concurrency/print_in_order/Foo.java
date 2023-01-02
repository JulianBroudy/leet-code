package io.broudy.leetcode.solutions.concurrency.print_in_order;

import java.util.concurrent.Semaphore;

public class Foo {

    Semaphore semaphore = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore.acquire();
        printSecond.run();
        semaphore.release(2);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!semaphore.tryAcquire(2)) {
        }
        printThird.run();
    }
}