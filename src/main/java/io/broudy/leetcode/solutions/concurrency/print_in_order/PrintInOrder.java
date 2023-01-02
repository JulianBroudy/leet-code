package io.broudy.leetcode.solutions.concurrency.print_in_order;

/**
 * 1114. Print in Order
 *
 * https://leetcode.com/problems/print-in-order/
 */
public class PrintInOrder {

    public static void main(String[] args) throws InterruptedException {

        Foo foo = new Foo();

        PrintInOrderThread a = new PrintInOrderThread(foo, 1, new Runnable() {
            @Override
            public void run() {
                System.out.println("First");
            }
        });
        PrintInOrderThread b = new PrintInOrderThread(foo, 2, new Runnable() {
            @Override
            public void run() {
                System.out.println("Second");
            }
        });
        PrintInOrderThread c = new PrintInOrderThread(foo, 3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Third");
            }
        });

        a.start();
        c.start();
        b.start();

    }

}
