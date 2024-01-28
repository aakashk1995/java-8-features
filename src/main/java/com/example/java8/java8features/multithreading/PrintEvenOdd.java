package com.example.java8.java8features.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintEvenOdd {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        Even even = new Even(integer);
        Odd odd = new Odd(integer);
        even.start();
        odd.start();

    }


}
class Even extends Thread{
    AtomicInteger integer;
    Even(AtomicInteger integer){
        this.integer = integer;
    }
    @Override
    public void run(){
        synchronized (integer){
            System.out.println("inside even "+ currentThread());
        while(integer.get()<=20){
            if(integer.get()%2==0){
                System.out.println("Even Number " + integer.getAndIncrement());
                try {

                    integer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            integer.notify();

            }
        }
    }
}
class Odd extends Thread{
    AtomicInteger integer;
    Odd(AtomicInteger integer){
        this.integer = integer;
    }
    @Override
    public void run(){
        synchronized (integer) {
            System.out.println("inside odd "+ currentThread());
        while(integer.get()<=20) {

                if (integer.get() % 2 != 0) {
                    System.out.println("Odd Number " + integer.getAndIncrement());
                    try {

                        integer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            integer.notify();

            }
        }
    }
}