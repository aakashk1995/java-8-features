package com.example.java8.java8features.corejava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface ahj{

    class pqr{

    }
}
public class StringTest {

    abstract class abstractClass{

    }
    interface MyTestInterface{

    }
   static Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    public static void main(String[] args) {


        String s2 = new String("abc");
        String s5 = s2.intern();
        System.out.println(s2==s5);
        String s1 = "abc";
        System.out.println(s1 == s5);

        StringBuilder stringBuilder1 = new StringBuilder("aakash");
        StringBuilder stringBuilder = new StringBuilder("aakash");
        System.out.println(stringBuilder.toString().equals(stringBuilder1.toString()));

        Thread thread = new Thread(runnable);



    }
}
