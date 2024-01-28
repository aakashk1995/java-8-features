package com.example.java8.java8features.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExecutorFramework {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Queue<Integer> queue = new ArrayDeque<>(10);
        Producer1 producer = new Producer1(queue);
        Consumer1 consumer = new Consumer1(queue);
        executor.submit(producer);
        executor.submit(consumer);

        executor.shutdown();

    }
}
class Producer1 extends Thread{
    Queue<Integer> queue;
    Producer1(Queue<Integer> queue){
        this.queue = queue;
    }
    public void run(){
        Random random = new Random();
        while (true){
            synchronized (queue) {
                if (queue.size() == 10) {
                    System.out.println("Queue :"+ queue.size());
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                queue.add(random.nextInt(100));
            queue.notify();
            }
        }
    }
}
class Consumer1 extends Thread{
    Queue<Integer> queue;
    Consumer1(Queue<Integer> queue){
        this.queue = queue;
    }
    public void run(){
        while (true){
            synchronized (queue) {
                if (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(queue.poll());
            queue.notify();
            }
        }
    }
}
