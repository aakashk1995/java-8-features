package com.example.java8.java8features.competableFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Handling_Errors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name1 = null;
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            if (name1 == null) {
                throw new RuntimeException("Computation Error!!!");
            }
            return "Hello," + name1;
        }).handle((result,exception) -> {
            System.out.println(result);
            if(result!=null)
                return result;
            else
                return "Hello Stranger !!";
        });
        System.out.println(completableFuture.get());
    }
}
