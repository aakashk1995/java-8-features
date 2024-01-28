package com.example.java8.java8features.programs;

public class Test2 {
    public static void main(String[] args) {
        String str = "aakash";
            //hsakaa
        //h
        //hs
        //hsa
        //hsak
        //hsaka
        //hsakaa
        char ch[] = str.toCharArray();

        for(char c: ch){
            System.out.println(c);
        }

        System.out.println(str.length());
    }
}
