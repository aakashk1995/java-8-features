package com.example.java8.java8features.multithreading;

class Counter {
    private static volatile int  count = 0;
    //private AtomicInteger count = new AtomicInteger(0);
    public  void increment() {
        count++;
       // count.incrementAndGet();
    }

    public int getCount() {
        return count;
    }
}

public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i =0;i<10000;i++) {
                counter.increment();
            }
            };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);


        try {
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());


    }
}
