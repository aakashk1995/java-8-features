package com.example.java8.java8features.competableFutures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTestException {
  static   ExecutorService service = Executors.newFixedThreadPool(10);
    public static void main(String[] args)  {
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
        Future<List<Integer>> future3 = service.submit(() -> {
            // your doing api call
            System.out.println("Thread name: " + Thread.currentThread().getName());

            System.out.println(10 / 0);
            return Arrays.asList(1, 2, 3, 4);
        });

        System.out.println("Printing after future");
        try {
            List<Integer> list3 = future3.get(); //5
            System.out.println(list3);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Printing after handling error in future");
        System.exit(0);
    }


}
