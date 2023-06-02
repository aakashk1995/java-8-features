package com.example.java8.java8features.corejava;

public class ImplicitConversion {
    public static void main(String[] args) {
        Integer integer = null;
        Boolean flag = null;
        short a = 2;
        int b = a; //implicit conversion
        short c = (short) b; //explicit conversion
        System.out.println(c);

        int d= 10;
        double e = d;

        System.out.println(e);
        //byte->short->int->long->float->double

        System.out.println(integer);
        System.out.println(flag);
    }
}
