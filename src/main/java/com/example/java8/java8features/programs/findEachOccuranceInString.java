package com.example.java8.java8features.programs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class findEachOccuranceInString {
    public static void main(String[] args) {
        String str = "ilovejavatechie";

        str.chars().mapToObj(value -> Character.toLowerCase(Character.valueOf((char) value)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().forEach(characterLongEntry -> System.out.println(characterLongEntry));

        Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Map<String, Long> collect2 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
// find duplicates in a string
        List<String> collect1 =  collect2.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() >1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(collect1);

        // find unique elements in a string
        List<String> uniqueElements =  collect2.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() ==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(collect1);

        // find first non repeat unique elements in a string -- use linkedhashmap to preserve insertion order by default it
        // will use hashmap to store collectors.groupingby output

        String nonRepeatFirst = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() ==1)
                .map(Map.Entry::getKey)
                .findFirst().get();

        System.out.println(nonRepeatFirst);



    }
}
