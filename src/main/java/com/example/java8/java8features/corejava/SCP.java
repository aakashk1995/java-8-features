package com.example.java8.java8features.corejava;

public class SCP {
    public static void main(String[] args) {

        String s1 = new String("aakash");
        String s3 = "aakash";
        String s2 =s1.intern();

        System.out.println(s1==s2);
        System.out.println(s2==s3);
        System.out.println(s1==s3);

        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());

        System.out.println("-----------------------------");

        String s4 = "ak";
        String s5 = s4.intern();

        System.out.println(s4==s5);

    }
}
