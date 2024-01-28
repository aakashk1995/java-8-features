package com.example.java8.java8features.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class CreatingThread {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        Runnable runnable = ()->{
            System.out.println("This is lamdba expression of runnable interface");
            while(true){
                System.out.println("Number " + i.getAndIncrement());
                if(i.get() == 10){
                  Thread.yield();
                    System.out.println("yeild compeleted");
                  break;
                }
            }
        };
        Thread th2 = new Thread(runnable);
        Thread th = new Thread(()->{
            System.out.println("This is lambda expression to override run method");
            while (true) {
                if(i.get()==10) {
                    try {
                        System.out.println(Thread.currentThread() + " Sleeping !!!");
                        Thread.sleep(10000);
                        System.out.println("sleeping finished");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
        });

        th2.start();
        th.start();


    }
}
