package io.broudy.leetcode.solutions.concurrency.fizz_buzz_multithreaded;

import io.broudy.leetcode.solutions.concurrency.common.IntConsumer;

public class FizzBuzz {

    private int n;

    private volatile int current;

    public FizzBuzz(int n) {
        this.n = n + 1;
        this.current = 1;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (current < n) {
            if (current % 3 == 0 && current % 5 != 0) {
                printFizz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (current < n) {
            if (current % 3 != 0 && current % 5 == 0) {
                printBuzz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current < n) {
            if (current % 15 == 0) {
                printFizzBuzz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (current < n) {
            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current);
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}
