package com.example.java8.java8features.corejava;

import java.io.IOException;
import java.util.Stack;

class superclass{
    public void test() throws RuntimeException{
        System.out.println("I'm from superclass");
    }
}

class subclass extends superclass{
    @Override
    public void test()  {
        System.out.println("Im'm from subclass");
    }
}
public class ExceptionHandleInOverRide {

    public static void main(String[] args) {
        superclass superclass = new subclass();

            superclass.test();

    }
}
