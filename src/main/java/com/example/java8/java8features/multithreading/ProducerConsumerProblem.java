package com.example.java8.java8features.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();

    }
}
class Producer extends Thread{
    Queue<Integer> queue;
    Producer(Queue<Integer> queue){
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
class Consumer extends Thread{
    Queue<Integer> queue;
    Consumer(Queue<Integer> queue){
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
