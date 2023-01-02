package io.broudy.leetcode.solutions.concurrency.print_foo_bar_alternately;

import java.util.concurrent.Semaphore;

class FooBar {

    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;
    private int n;

    public FooBar(int n) {
        this.n = n;
        this.fooSemaphore = new Semaphore(1);
        this.barSemaphore = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
           fooSemaphore.acquire(i+1);
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            fooSemaphore.release();
            barSemaphore.release(i+1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire(i+1);
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            barSemaphore.release();
            fooSemaphore.release(i+1);
        }
    }
}
