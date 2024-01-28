package com.example.java8.java8features.programs;

public class Testor {

    public static void main(String[] args) {
        //sorting
        boolean hasAfterKey1 = true;
        boolean snapshot = false;

        //exporting
        boolean hasAfterKey2 = true;
        boolean startRow2 = true;

        System.out.println((hasAfterKey1&&snapshot) || (hasAfterKey2&&startRow2) ? 1 : 2);
    }
}
