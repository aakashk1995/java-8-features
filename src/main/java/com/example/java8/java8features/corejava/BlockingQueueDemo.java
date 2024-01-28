package com.example.java8.java8features.corejava;

import java.util.Timer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    public static BlockingQueue<Integer> BLOCKING_QUEUE = new LinkedBlockingQueue<Integer>(5);

    public static volatile int number = 10;
    public static void main(String[] args) {

        Runnable producer  = () ->{
          for(int i = 0 ;i <= number; i++){
              try {
                  BLOCKING_QUEUE.put(i);
                  System.out.println("Produced " + i +  " " + Thread.currentThread() + " Remaining Cacpacity " +
                          BLOCKING_QUEUE.remainingCapacity());

              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        };

        Runnable consumer = () ->{
          while(true){
              try {
                  Thread.sleep(20000);
                  Integer integer =  BLOCKING_QUEUE.take();
                  System.out.println("Consumed "+ integer + " " + Thread.currentThread());

              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }


        };

        Thread th1 = new Thread(producer);
        Thread th3 = new Thread(producer);
        Thread th2 = new Thread(consumer);
        th1.start();
        th3.start();
        th2.start();

    }
}
