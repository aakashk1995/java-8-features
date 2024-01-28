package com.example.java8.java8features.multithreading;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class CopyOnWriteArrayListEx {
    public static void main(String[] args) {
        List<Integer> integerList = new CopyOnWriteArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        Iterator<Integer> iterator = integerList.iterator();
        integerList.add(5);
        while ((iterator.hasNext())){
            Integer a = iterator.next();
            System.out.println(a);
        }
        System.out.println(integerList);


    }
}
