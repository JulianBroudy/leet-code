package io.broudy.leetcode.solutions.concurrency.fizz_buzz_multithreaded;

/**
 * 1195. Fizz Buzz Multithreaded
 *
 * https://leetcode.com/problems/fizz-buzz-multithreaded/description/
 */
public class FizzBuzzMultithreaded {

    public static void main(String[] args) throws InterruptedException {

        final int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        FizzBuzzMultithreadedThread a = new FizzBuzzMultithreadedThread(fizzBuzz, FizzBuzzMethods.FIZZ,  new Runnable() {
            @Override
            public void run() {
                System.out.print("Fizz, ");
            }
        });
        FizzBuzzMultithreadedThread b = new FizzBuzzMultithreadedThread(fizzBuzz, FizzBuzzMethods.BUZZ, new Runnable() {
            @Override
            public void run() {
                System.out.print("Buzz, ");
            }
        });
        FizzBuzzMultithreadedThread c = new FizzBuzzMultithreadedThread(fizzBuzz, FizzBuzzMethods.FIZZBUZZ, new Runnable() {
            @Override
            public void run() {
                System.out.print("FizzBuzz, ");
            }
        });
        FizzBuzzMultithreadedThread d = new FizzBuzzMultithreadedThread(fizzBuzz, FizzBuzzMethods.NUMBER, new Runnable() {
            @Override
            public void run() {
                System.out.println("Number");
            }
        });

        d.start();
        a.start();
        b.start();
        c.start();

    }

    public enum FizzBuzzMethods{
        FIZZ, BUZZ, FIZZBUZZ, NUMBER
    }

}
