package com.example.java8.java8features.corejava;

import java.util.stream.Stream;

public class Child extends Parent{

    @Override
    public void parentMethod(){
        super.parentMethod();
        System.out.println("I'm inside child method");
    }

    public static void main(String[] args) {
        Child child = new Child();
        Stream<String> stream = Stream.of("Geeks", "fOr",
                "GEEKSQUIZ", "GeeksforGeeks");
       boolean ans = stream.anyMatch(s -> s.equalsIgnoreCase("fOr"));
        System.out.println(ans);
    }

}
