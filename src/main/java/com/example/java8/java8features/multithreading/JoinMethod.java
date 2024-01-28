package com.example.java8.java8features.multithreading;

public class JoinMethod {
    public static void main(String[] args)  {
        Thread th1 = new Thread(()->{
            System.out.println("This is thread 1");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread th2 = new Thread(()->{
            System.out.println("This is thread 2");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread th3 = new Thread(()->{
            System.out.println("This is thread 3");
            try {
                Thread.sleep(5000);
                System.out.println("Thread 3 sleeping !!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            th3.start();
            th2.start();
            th1.start();
            th3.join();

            th2.join();

            th1.join();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("joiin ");

    }
}
