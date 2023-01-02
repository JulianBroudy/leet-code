package io.broudy.leetcode.solutions.concurrency.print_in_order;

public class PrintInOrderThread extends Thread {

    Foo foo;
    int method;
    Runnable runnable;

    public PrintInOrderThread(Foo foo, int method, Runnable runnable) {
        this.foo = foo;
        this.method = method;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        switch (method) {
            case 1: {
                try {
                    foo.first(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                try {
                    foo.second(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3: {
                try {
                    foo.third(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}
