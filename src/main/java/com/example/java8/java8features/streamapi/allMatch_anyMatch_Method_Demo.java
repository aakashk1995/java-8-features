package com.example.java8.java8features.streamapi;

import java.util.Arrays;
import java.util.List;

public class allMatch_anyMatch_Method_Demo {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3, 4, 6, 12, 20);

        boolean answer1 = list1.stream().allMatch(num -> num % 3 == 0);
        System.out.println(answer1);// false

        boolean answer2 = list1.stream().anyMatch(num -> num % 3 == 0);
        System.out.println(answer2);// true

        // to check whether strings have length greater than 2.
        List<String> list2 = Arrays.asList("Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
        System.out.println(list2.stream().allMatch(str -> str.length() > 4));// false
        System.out.println(list2.stream().anyMatch(str -> str.length() > 4));// true
    }
}
