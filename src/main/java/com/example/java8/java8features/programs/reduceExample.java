package com.example.java8.java8features.programs;

import java.util.Arrays;

public class reduceExample {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d", "e"};
        String reduce2 = Arrays.stream(strings).reduce("", (a, b) -> {
            if (!"".equals(a)) {
                return a + "|" + b;
            } else {
                return b;
            }
        });

        System.out.println(reduce2);

        String[] arrays = {"java","is", "love" , "Important"};
        String word = Arrays.stream(arrays).reduce((word1,word2)-> word1.length()>word2.length()?word1:word2).get();

        System.out.println(word);

    }
}
