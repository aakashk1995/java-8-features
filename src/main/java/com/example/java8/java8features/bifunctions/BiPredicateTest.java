package com.example.java8.java8features.bifunctions;

import java.util.function.BiPredicate;

public class BiPredicateTest {
    public static void main(String[] args) {
        BiPredicate<String,String> biPredicate = (input1,input2) -> input1.equals(input2);
        System.out.println(biPredicate.test("aakash","Aakash"));


    }
}
