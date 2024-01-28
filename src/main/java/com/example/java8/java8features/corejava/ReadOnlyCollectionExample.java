package com.example.java8.java8features.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadOnlyCollectionExample {
    public static void main(String[] args) {
        List<String> mutualableList = new ArrayList<>();
        mutualableList.add("aakash");
        mutualableList.add("sakshi");

        System.out.println(mutualableList);

       List<String> readOnlyList =  Collections.unmodifiableList(mutualableList);

       mutualableList.add("sonal");

        System.out.println(readOnlyList);
    }
}
