package com.example.java8.java8features.multithreading;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static final int THREAD_COUNT = 3;
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> {
            // This runnable will be executed once all threads reach the barrier
            System.out.println("Barrier is tripped, all threads can proceed.");
        });
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " is waiting at the barrier.");
                    barrier.await();
                    System.out.println("Thread " + Thread.currentThread().getId() + " continues after the barrier.");
                    //barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            //thread.start();
        }
    }
}
