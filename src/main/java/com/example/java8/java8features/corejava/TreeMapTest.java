package com.example.java8.java8features.corejava;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,6);
        treeMap.put(3,1);
        treeMap.put(2,3);
        System.out.println(treeMap);

    }
}
