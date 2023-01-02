package io.broudy.leetcode.solutions.concurrency.print_foo_bar_alternately;

/**
 * 1115. Print FooBar Alternately
 *
 * https://leetcode.com/problems/print-foobar-alternately/
 */
public class PrintFooBarAlternately {
    
    public static void main(String[] args) throws InterruptedException {

        final int n = 5;
        FooBar fooBar = new FooBar(n);

        PrintFooBarAlternatelyThread a = new PrintFooBarAlternatelyThread(fooBar, FooOrBar.FOO, new Runnable() {
            @Override
            public void run() {
                System.out.println("Foo");
            }
        });
        PrintFooBarAlternatelyThread b = new PrintFooBarAlternatelyThread(fooBar, FooOrBar.BAR, new Runnable() {
            @Override
            public void run() {
                System.out.println("Bar");
            }
        });

        a.start();
        b.start();

    }

    public enum FooOrBar{
        FOO, BAR
    }

}
