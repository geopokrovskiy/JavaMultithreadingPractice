package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                synchronized (foo) {
                    foo.first(this);
                }
            }
        };

        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                synchronized (foo) {
                    foo.second(this);
                }
            }
        };

        Runnable thread3 = new Runnable() {
            @Override
            public void run() {
                synchronized (foo) {
                    foo.third(this);
                }
            }
        };

        try(ScheduledExecutorService service1 = Executors.newScheduledThreadPool(3)){
            service1.schedule(thread1, 100, TimeUnit.MILLISECONDS);
            service1.schedule(thread2, 200, TimeUnit.MILLISECONDS);
            service1.schedule(thread3, 300, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service2 = Executors.newScheduledThreadPool(3)){
            service2.schedule(thread1, 100, TimeUnit.MILLISECONDS);
            service2.schedule(thread3, 300, TimeUnit.MILLISECONDS);
            service2.schedule(thread2, 200, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service3 = Executors.newScheduledThreadPool(3)){
            service3.schedule(thread2, 200, TimeUnit.MILLISECONDS);
            service3.schedule(thread1, 100, TimeUnit.MILLISECONDS);
            service3.schedule(thread3, 300, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service4 = Executors.newScheduledThreadPool(3)){
            service4.schedule(thread2, 200, TimeUnit.MILLISECONDS);
            service4.schedule(thread3, 300, TimeUnit.MILLISECONDS);
            service4.schedule(thread1, 100, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service5 = Executors.newScheduledThreadPool(3)){
            service5.schedule(thread3, 300, TimeUnit.MILLISECONDS);
            service5.schedule(thread1, 100, TimeUnit.MILLISECONDS);
            service5.schedule(thread2, 200, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service6 = Executors.newScheduledThreadPool(3)){
            service6.schedule(thread3, 300, TimeUnit.MILLISECONDS);
            service6.schedule(thread2, 200, TimeUnit.MILLISECONDS);
            service6.schedule(thread1, 100, TimeUnit.MILLISECONDS);
        }
    }
}