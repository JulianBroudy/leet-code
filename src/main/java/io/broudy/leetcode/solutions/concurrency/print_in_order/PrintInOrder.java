package io.broudy.leetcode.solutions.concurrency.print_in_order;

/**
 * <a href="https://leetcode.com/problems/print-in-order/">1114. Print in Order</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class PrintInOrder {

    public static void main(String[] args) throws InterruptedException {

        Foo foo = new Foo();

        PrintInOrderThread a = new PrintInOrderThread(foo, 1, () -> System.out.println("First"));
        PrintInOrderThread b = new PrintInOrderThread(foo, 2, () -> System.out.println("Second"));
        PrintInOrderThread c = new PrintInOrderThread(foo, 3, () -> System.out.println("Third"));

        a.start();
        c.start();
        b.start();

    }

}
