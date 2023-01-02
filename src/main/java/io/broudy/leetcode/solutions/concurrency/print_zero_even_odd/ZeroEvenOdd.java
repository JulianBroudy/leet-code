package io.broudy.leetcode.solutions.concurrency.print_zero_even_odd;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {

    private final Semaphore zeroSemaphore;
    private final Semaphore nSemaphore;

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroSemaphore = new Semaphore(1);
        this.nSemaphore = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire(i + 1);
            printNumber.accept(0);
            zeroSemaphore.release(i + 1);
            nSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (!nSemaphore.tryAcquire(i)) {
            }
            printNumber.accept(i);
            nSemaphore.release(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (!nSemaphore.tryAcquire(i)) {
            }
            printNumber.accept(i);
            nSemaphore.release(i);
            zeroSemaphore.release();
        }
    }
}
