package io.broudy.leetcode.solutions.concurrency.fizz_buzz_multithreaded;

import io.broudy.leetcode.solutions.concurrency.common.IntConsumer;
import io.broudy.leetcode.solutions.concurrency.fizz_buzz_multithreaded.FizzBuzzMultithreaded.FizzBuzzMethods;
import io.broudy.leetcode.solutions.concurrency.print_zero_even_odd.PrintZeroEvenOdd.ZeroOrEvenOrOdd;

public class FizzBuzzMultithreadedThread extends Thread {

    private final FizzBuzz fizzBuzz;
    private final FizzBuzzMethods fizzBuzzMethods;
    private final Runnable runnable;

    public FizzBuzzMultithreadedThread(FizzBuzz fizzBuzz, FizzBuzzMethods fizzBuzzMethods, Runnable runnable) {
        this.fizzBuzz = fizzBuzz;
        this.fizzBuzzMethods = fizzBuzzMethods;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        switch (fizzBuzzMethods) {
            case FIZZ: {
                try {
                    fizzBuzz.fizz(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case BUZZ: {
                try {
                    fizzBuzz.buzz(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case FIZZBUZZ: {
                try {
                    fizzBuzz.fizzbuzz(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case NUMBER: {
                try {
                    fizzBuzz.number(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}
