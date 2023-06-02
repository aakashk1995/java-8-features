package com.example.java8.java8features.programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program1 {

    public static void main(String[] args) {
       // findAllEvenNumbersExist();
      //  findDuplicates();
      //  findMax();
        findFirstNonRepeatedCharacter();
    }

    //From a list of 20 numbers find odd numbers and square and add them using java
    //streams.
    public static void findOddNumbersAndAddThem(){
        List<Integer> integersList= new ArrayList<>();
        for(int i=0;i<=5;i++){
            integersList.add(i);
        }
        int sum =  integersList.stream()
                .filter(integer -> integer%2!=0)
                .map(integer -> integer*integer)
                .mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    //Given a list of integers, find out all the even numbers exist in the list using Stream functions?

    public static  void findAllEvenNumbersExist(){
        List<Integer> evenNumberList =Arrays.asList(10,15,8,49,25,98,32);
        boolean flag = evenNumberList.stream()
                .allMatch(integer -> integer%2==0 )
                ;
        System.out.println(flag);
    }
   // Given a list of integers, find out all the numbers starting with 1 using Stream functions?
    public static void findStartsWith(){
        //String.valueOf(integer).startsWith("1")
    }

    //find duplicate elements in List using streams

    public static void findDuplicates(){
        List<Integer> numberList =Arrays.asList(10,32,8,49,10,8,32);
   List<Integer> duplicateNo =   numberList.stream()
                .collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()))
                        .entrySet().stream()
                       .filter(integerLongEntry -> integerLongEntry.getValue()>1)
               .map(integerLongEntry -> integerLongEntry.getKey())
                               .collect(Collectors.toList());
        System.out.println(duplicateNo);

    }
    //Given a list of integers, find the maximum value element present in it using Stream functions?

    public static void findMax(){
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int max1 = myList.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
      int max2 =  myList.stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .get();
        int max3 = myList.stream()
                .max(Integer::compare).get();
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);
    }
    //Given a String, find the first non-repeated character in it using Stream functions?

    public static void findFirstNonRepeatedCharacter(){
        String input = "Java Hungry Blog Alive is Awesome";
     //   System.out.println(input.lines().count());
     //   input.lines().forEach(System.out::println);
     char ch=  input.chars().mapToObj(value -> Character.toLowerCase(Character.valueOf((char) value)))
              .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
              .entrySet().stream()
              .filter(characterLongEntry -> characterLongEntry.getValue()==1L)
              .map(characterLongEntry -> characterLongEntry.getKey())
              .findFirst().get();
        System.out.println(ch);

    }
    //Write a Java 8 program to square the list of numbers and then filter out the numbers greater
    // than 100 and then find the average of the remaining numbers?

    public static void findSquareAndAverage(){
        List<Integer> numbers =Arrays.asList(9,13,10,2,6,14);
     Double average=   numbers.stream()
                .map(integer -> integer*integer)
                .filter(integer -> integer>100)
                .mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(average);
    }


}
