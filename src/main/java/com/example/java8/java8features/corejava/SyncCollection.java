package com.example.java8.java8features.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class SyncCollection {
    public static void main(String[] args)  {
       // Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        ArrayList<Integer> syncCollection = new ArrayList<Integer>();

        Runnable listOperations2 = () -> {
            syncCollection.addAll(Arrays.asList(1,2,3,4,5,7));
            try {
               // Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        Runnable listOperations = () -> {
       //     syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            for(int i = 0;i <= 5;i++){
                syncCollection.add(i);
//                if(i==10) {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }

                //System.out.println(i + " Current thread " + Thread.currentThread());
            }
        };

        Thread thread1 = new Thread(listOperations2);
        Thread thread2 = new Thread(listOperations2);
        Thread thread3 = new Thread(listOperations2);

        try {
            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(syncCollection);
    }
}
