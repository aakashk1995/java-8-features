package com.example.java8.java8features.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintEvenOddV2 {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();
        Thread th1 = new Thread(()->{
           while (true){
             //  numberPrinter.printEven2();
               numberPrinter.printEven();
           }
        });
        Thread th2 = new Thread(()->{
            while (true){
               // numberPrinter.printOdd2();
                numberPrinter.printOdd();
            }
        });
        th1.start();
        th2.start();
    }
}
class NumberPrinter{
    int count = 0;
    final Object lock = new Object();

    Lock lock2 = new ReentrantLock();

    Condition condition  = lock2.newCondition();

    public  void printEven2() {
        try {
            if(lock2.tryLock(10, TimeUnit.SECONDS)){
                lock2.lock();
                if (count % 2 == 0) {
                    System.out.println("Even number " + count);
                   condition.await();
                }
                count++;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock2.unlock();
        }
    }
    public  void printOdd2() {
        try{
            if(lock2.tryLock(10,TimeUnit.SECONDS)){
                lock2.lock();
                if (count % 2 != 0) {
                    System.out.println("Odd number " + count);
                    condition.await();
                }
            }
            count++;
            condition.signalAll();
        }catch (Exception ex){
            System.out.println(ex);
        }finally {
            lock2.unlock();
        }
    }
    public  void printEven() {
        synchronized (lock) {
            if (count % 2 == 0) {
                System.out.println("Even number " + count);
                try {
                    lock.wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            count++;
            lock.notify();
        }
    }

    public  void printOdd() {
        synchronized (lock) {
            if (count % 2 != 0) {
                System.out.println("Odd number " + count);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            count++;
            lock.notify();
        }

    }
}
