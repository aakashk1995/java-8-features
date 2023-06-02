package com.example.java8.java8features.corejava;


import java.util.ArrayList;
import java.util.List;

class C {
    int a;
}
class D extends C{
    int b;
}

public class InstanceOf {
    public static void main(String[] args) {
        ArrayList a = new ArrayList<>();

        System.out.println(a instanceof ArrayList);
        System.out.println(a instanceof List);

        B b = new B();
        System.out.println(b instanceof B);
        System.out.println(b instanceof A);
        System.out.println(b instanceof Object);
        System.out.println(b instanceof List);
        //instanceof will return true in case of Child Class, Parent class , Interface

        int count = 50;

        switch (count){
            case 40:
                System.out.println();

        }

    }
}
