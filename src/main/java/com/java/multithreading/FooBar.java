package com.java.multithreading;

import java.util.concurrent.Semaphore;

class FooBarCon {
    int n;
    Semaphore fooLock;
    Semaphore barLock;

    public FooBarCon(int n) {
        this.n = n;
        this.fooLock = new Semaphore(1);
        this.barLock = new Semaphore(0);
    }

    public void printFoo(Runnable r) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooLock.acquire();
            r.run();
            barLock.release();
        }
    }

    public void printBar(Runnable r) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barLock.acquire();
            r.run();
            fooLock.release();
        }
    }
}


public class FooBar {
    public static void main(String[] args) {
        FooBarCon fooBarCon = new FooBarCon(5);

        Thread fooThread = new Thread(() -> {
            try {
                fooBarCon.printFoo(() -> System.out.println("foo "));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
               fooBarCon.printBar(()-> System.out.println("bar "));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        fooThread.start();
        barThread.start();

    }
}
