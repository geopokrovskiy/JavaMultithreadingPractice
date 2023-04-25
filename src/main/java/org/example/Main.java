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
                foo.first(this);
            }
        };

        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                foo.second(this);
            }
        };

        Runnable thread3 = new Runnable() {
            @Override
            public void run() {
                foo.third(this);
            }
        };

        try(ScheduledExecutorService service1 = Executors.newSingleThreadScheduledExecutor()){
            service1.schedule(thread1, 100, TimeUnit.MILLISECONDS);
            service1.schedule(thread2, 200, TimeUnit.MILLISECONDS);
            service1.schedule(thread3, 300, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service2 = Executors.newSingleThreadScheduledExecutor()){
            service2.schedule(thread1, 10, TimeUnit.MILLISECONDS);
            service2.schedule(thread3, 30, TimeUnit.MILLISECONDS);
            service2.schedule(thread2, 20, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service3 = Executors.newSingleThreadScheduledExecutor()){
            service3.schedule(thread2, 20, TimeUnit.MILLISECONDS);
            service3.schedule(thread1, 10, TimeUnit.MILLISECONDS);
            service3.schedule(thread3, 30, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service4 = Executors.newSingleThreadScheduledExecutor()){
            service4.schedule(thread2, 20, TimeUnit.MILLISECONDS);
            service4.schedule(thread3, 30, TimeUnit.MILLISECONDS);
            service4.schedule(thread1, 10, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service5 = Executors.newSingleThreadScheduledExecutor()){
            service5.schedule(thread3, 30, TimeUnit.MILLISECONDS);
            service5.schedule(thread1, 10, TimeUnit.MILLISECONDS);
            service5.schedule(thread2, 20, TimeUnit.MILLISECONDS);
        }

        System.out.println();

        try(ScheduledExecutorService service6 = Executors.newSingleThreadScheduledExecutor()){
            service6.schedule(thread3, 300, TimeUnit.MILLISECONDS);
            service6.schedule(thread2, 200, TimeUnit.MILLISECONDS);
            service6.schedule(thread1, 100, TimeUnit.MILLISECONDS);
        }
    }
}