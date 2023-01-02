package io.broudy.leetcode.solutions.concurrency.print_foo_bar_alternately;

import io.broudy.leetcode.solutions.concurrency.print_foo_bar_alternately.PrintFooBarAlternately.FooOrBar;

public class PrintFooBarAlternatelyThread extends Thread {

    FooBar fooBar;
    FooOrBar fooOrBar;
    Runnable runnable;

    public PrintFooBarAlternatelyThread(FooBar fooBar, FooOrBar fooOrBar, Runnable runnable) {
        this.fooBar = fooBar;
        this.fooOrBar = fooOrBar;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        switch (fooOrBar) {
            case FOO: {
                try {
                    fooBar.foo(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case BAR: {
                try {
                    fooBar.bar(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}
