package com.example.java8.java8features.corejava;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetImpl {
    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(4);
        sortedSet.add(2);
        sortedSet.add(4);


        System.out.println(sortedSet);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(4);
        linkedHashSet.add(14);
        linkedHashSet.add(1);
        linkedHashSet.add(null);
        System.out.println(linkedHashSet);

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(4);
        hashSet.add(14);
        hashSet.add(null);
        hashSet.add(1);


        System.out.println(hashSet);

    }
}
