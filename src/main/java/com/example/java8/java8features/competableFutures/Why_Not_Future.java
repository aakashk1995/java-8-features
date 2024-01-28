package com.example.java8.java8features.competableFutures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * What is CompletableFuture ?
 * <p>
 * CompletableFuture is a new era of asynchronous programming.It's introduced as
 * a Java 8 Concurrency API improvement.
 * <p>
 * Asynchronous Computation in JAVA
 * <p>
 * The future interface was added in Java 5 to serve as a result of an
 * asynchronous computation, but it did not have any methods to combine these
 * computations or handle possible errors.
 * <p>
 * In Java8, the CompletableFuture class was introduced. Along with the Future
 * interface, it also implements the CompletionStage interface. This interface
 * defines the contract for an asynchronous computation step that can be
 * combined with other steps.
 * <p>
 * CompletableFuture is at the same time a building block and a framework with
 * different methods for composing, combining, executing asynchronous compuation
 * steps and handling errors.
 * <p>
 * Using Asynchronous programming we can write non blocking code where
 * concurrently we can run N no of task in separate thread without blocking main
 * thread.
 * <p>
 * When the task is complete, it notifies to the main thread (whether the task
 * was completed or failed).
 * <p>
 * Why CompletableFuture ?
 * <p>
 * There are different ways to implement asynchronous programming in Java using
 * any of the below mechanism for example we can use
 * Futures,ExecutorService,Callback Interfaces, Thread Pools etc.
 * <p>
 * It can not be manually completed.
 * <p>
 * Multiple Futures can not be chained together.
 * <p>
 * we can not combine multiple Futures together.
 * <p>
 * No Proper Exception Handling Mechanism.
 */
public class Why_Not_Future {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<List<Integer>> future1 = service.submit(() -> {
            // your doing api call
            System.out.println("Thread name: " + Thread.currentThread().getName());
            delay(15);
            return Arrays.asList(1, 2, 3, 4);
        });

        Future<List<Integer>> future2 = service.submit(() -> {
            // your doing api call
            System.out.println("Thread name: " + Thread.currentThread().getName());
            delay(20);
            return Arrays.asList(1, 2, 3, 4);
        });

        Future<List<Integer>> future3 = service.submit(() -> {
            // your doing api call

            System.out.println("Thread name: " + Thread.currentThread().getName());

            delay(5);
            //System.out.println(10 / 0);

            return Arrays.asList(1, 2, 3, 4);
        });

        // We can run separate future object but can't chain multiple future objects.
        List<Integer> list1 = future1.get();  //15
        List<Integer> list2 = future2.get(); //20
        List<Integer> list3 = future3.get(); //5
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);// no exception handling for future object

        // (future1*future2*future3).get() it's not possible.

        /**
         * Here we can complete the thread manually and thread is not blocked.
         */
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.get();
        completableFuture.complete("return some dummy data");

    }

    private static void delay(int min) {
        try {
            TimeUnit.SECONDS.sleep(min);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
