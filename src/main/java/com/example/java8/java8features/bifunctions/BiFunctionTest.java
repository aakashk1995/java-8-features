package com.example.java8.java8features.bifunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionTest {
    public static void main(String[] args) {
        BiFunction<List<String>, List<String>, List<String>> biFunction =
                (list1, list2) -> {
                    System.out.println(list1);
                    System.out.println(list2);
                    List<String> finalList = new ArrayList<>();
                    finalList.addAll(list1);
                    finalList.addAll(list2);
                    return finalList;
                };
        List<String> result = biFunction.apply(Arrays.asList("aakash"), Arrays.asList("khatavkar"));
        System.out.println(result);
    }
}
