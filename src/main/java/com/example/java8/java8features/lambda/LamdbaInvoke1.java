package com.example.java8.java8features.lambda;

import java.util.function.Predicate;

@FunctionalInterface
interface MyInterface1{
    public int countLengthOfString(String s);
}
public class LamdbaInvoke1 {
    public static void main(String[] args) {
        MyInterface1 myInterface1 = (s)-> s.length();
        System.out.println(myInterface1.countLengthOfString("aakash"));
        Predicate<Integer> salaryPredicate = (salary)-> (salary>4000) ? true : false;
        boolean result = salaryPredicate.test(5000);
        System.out.println(result);
    }
}
