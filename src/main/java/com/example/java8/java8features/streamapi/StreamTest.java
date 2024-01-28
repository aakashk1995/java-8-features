package com.example.java8.java8features.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,5,3,13,34,23);

        Stream<Integer> listStream = integerList.stream().filter(i->i>5);

        System.out.println(listStream.collect(Collectors.toList()));
        System.out.println(listStream.collect(Collectors.toList()));

    }
}
