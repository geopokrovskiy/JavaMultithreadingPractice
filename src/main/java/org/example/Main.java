package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        ExecutorService service = Executors.newSingleThreadExecutor();
        Thread t1 = new Thread("Thread1");
        Thread t2 = new Thread("Thread2");
        Thread t3 = new Thread("Thread3");


        try {
            foo.first(t1);
            foo.second(t2);
            foo.third(t3);

            System.out.println();

            foo.first(t1);
            foo.second(t3);
            foo.third(t2);

            System.out.println();

            foo.first(t2);
            foo.second(t1);
            foo.third(t3);

            System.out.println();

            foo.first(t2);
            foo.second(t3);
            foo.third(t1);

            System.out.println();

            foo.first(t3);
            foo.second(t1);
            foo.third(t2);

            System.out.println();

            foo.first(t3);
            foo.second(t2);
            foo.third(t1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}