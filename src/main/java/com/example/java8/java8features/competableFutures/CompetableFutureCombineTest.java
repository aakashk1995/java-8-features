package com.example.java8.java8features.competableFutures;

import java.util.concurrent.CompletableFuture;

public class CompetableFutureCombineTest {
    public static void main(String[] args) {
        CompletableFuture<Integer> cf1 = new CompletableFuture<>();
        CompletableFuture<Integer> cf2 = cf1.thenApply(integer -> integer*10).thenApply(integer -> integer+10);
         cf1.complete(1);
        cf2.thenAccept(System.out::println);

    }
}
