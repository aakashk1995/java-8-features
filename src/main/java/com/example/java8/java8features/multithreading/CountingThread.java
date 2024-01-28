package com.example.java8.java8features.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CountingThread {
    public static void main(String[] args) throws InterruptedException {
      Counter1 counter = new Counter1();
        IncrementingThread th1 = new IncrementingThread(counter);
        DecementingThread th2 = new DecementingThread(counter);
        th1.start();

        th2.start();
        th1.join();
        th2.join();
        System.out.println(counter.value());
    }
}
class IncrementingThread extends Thread{
    Counter1 c ;
    IncrementingThread(Counter1 c){
        this.c = c;
    }
    @Override
    public void run(){
        for(int i=0;i<10000;i++){
            this.c.increment();
        }
    }
}

class DecementingThread extends Thread{
    Counter1 c ;
    DecementingThread(Counter1 c){
        this.c = c;
    }
    @Override
    public void run(){
        for(int i=0;i<10000;i++){
            this.c.decerement();
        }
    }
}
class Counter1{
    private AtomicInteger count = new AtomicInteger(0);

    public void increment(){
        count.getAndIncrement();
    }
    public void decerement(){
       count.getAndDecrement();
    }
    public int value(){
        return count.get();
    }
}
