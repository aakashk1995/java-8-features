package com.example.java8.java8features.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class findSecondHighestNumberInArray {
    public static void main(String[] args) {
        int[] a = {5,9,8,11,2,21,1};

      List<Integer> integerList =   Arrays.stream(a).boxed()
                .sorted(Comparator.reverseOrder())
              .skip(1)

                .collect(Collectors.toList());
      Integer secondHighst =  integerList.stream().findFirst().get();

        System.out.println(integerList);
        System.out.println(secondHighst);
    }
}
