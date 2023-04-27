package org.example;

import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(0);
    private Semaphore sem3 = new Semaphore(0);
    public void first(Runnable r) throws InterruptedException {
        sem1.acquire();
        System.out.print("first");
        sem2.release();
    }
    public void second(Runnable r) throws InterruptedException {
        sem2.acquire();
        System.out.print("second");
        sem3.release();
    }
    public void third(Runnable r) throws InterruptedException {
        sem3.acquire();
        System.out.print("third");
        sem1.release();
    }
}
