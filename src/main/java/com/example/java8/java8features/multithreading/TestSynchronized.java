package com.example.java8.java8features.multithreading;

import com.example.java8.java8features.corejava.Student;

public class TestSynchronized {

    Object lock ;
    public  int counter = 0;

    TestSynchronized(Object lock){
        this.lock = lock;
    }

    public void testSync(){
        synchronized (lock){
            counter++;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Current thread " + Thread.currentThread().getName() + " Counter value " + counter);
        }
    }
}

class TestSync{
    public static void main(String[] args) {
        Object lock = new Object();
        TestSynchronized testSynchronized =  new TestSynchronized(lock);
        TestSynchronized testSynchronized1 =  new TestSynchronized(lock);
        Runnable r1 = ()-> testSynchronized.testSync();
        Runnable r2 = ()-> testSynchronized1.testSync();
        Thread t1 = new Thread(r1);
        t1.setName("Thread 1");
        Thread t2 = new Thread(r2);
        t2.setName("Thread 2");
        Thread t3 = new Thread(r1);
        t3.setName("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
