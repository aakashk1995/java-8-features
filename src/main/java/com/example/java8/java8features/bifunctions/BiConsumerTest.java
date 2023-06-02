package com.example.java8.java8features.bifunctions;

import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
        BiConsumer<String,Integer> biConsumer = (input1, input2)->{
            System.out.println(input1);
            System.out.println(input2);
        };

        biConsumer.accept("Aakash",2);
    }
}
