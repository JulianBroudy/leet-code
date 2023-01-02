package io.broudy.leetcode.solutions.concurrency.print_zero_even_odd;

import io.broudy.leetcode.solutions.concurrency.common.IntConsumer;
import io.broudy.leetcode.solutions.concurrency.print_zero_even_odd.PrintZeroEvenOdd.ZeroOrEvenOrOdd;

public class PrintZeroEvenOddThread extends Thread {

    ZeroEvenOdd zeroEvenOdd;
    ZeroOrEvenOrOdd zeroOrEvenOrOdd;

    public PrintZeroEvenOddThread(ZeroEvenOdd zeroEvenOdd, ZeroOrEvenOrOdd zeroOrEvenOrOdd) {
        this.zeroEvenOdd = zeroEvenOdd;
        this.zeroOrEvenOrOdd = zeroOrEvenOrOdd;
    }

    @Override
    public void run() {
        switch (zeroOrEvenOrOdd) {
            case ZERO: {
                try {
                    zeroEvenOdd.zero(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case EVEN: {
                try {
                    zeroEvenOdd.even(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case ODD: {
                try {
                    zeroEvenOdd.odd(new IntConsumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}
