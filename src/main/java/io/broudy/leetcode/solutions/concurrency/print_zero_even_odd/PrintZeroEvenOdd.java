package io.broudy.leetcode.solutions.concurrency.print_zero_even_odd;

/**
 * 1116. Print Zero Even Odd
 *
 * https://leetcode.com/problems/print-zero-even-odd/description/
 */
public class PrintZeroEvenOdd {

    public static void main(String[] args) throws InterruptedException {

        final int n = 200;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        PrintZeroEvenOddThread a = new PrintZeroEvenOddThread(zeroEvenOdd, ZeroOrEvenOrOdd.ZERO);
        PrintZeroEvenOddThread b = new PrintZeroEvenOddThread(zeroEvenOdd, ZeroOrEvenOrOdd.EVEN);
        PrintZeroEvenOddThread c = new PrintZeroEvenOddThread(zeroEvenOdd, ZeroOrEvenOrOdd.ODD);

        a.start();
        b.start();
        c.start();

    }

    public enum ZeroOrEvenOrOdd{
        ZERO, EVEN, ODD
    }

}
