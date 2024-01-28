package com.example.java8.java8features.corejava;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(null);
        vector.add(3.013f);
        vector.add(new BigDecimal(2312.23, MathContext.DECIMAL64));
        vector.add(new Student());

        Iterator iterator = vector.iterator();

        while ((iterator.hasNext()))
        {
           Object object =  iterator.next();
            System.out.println(object);
        }
        // key, value
        //key
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        hashSet.add(null);
        hashSet.add(new Student());

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("M");
        treeSet.add("R");
        treeSet.add("K");
        treeSet.add("A");
        treeSet.add("L");

        System.out.println(treeSet);

        HashMap hashMap = new HashMap();
        hashMap.put(1,2);
        hashMap.put(1,3);
        hashMap.put(null,4);
        hashMap.put(null,3);

        hashMap.get(1);


        System.out.println(hashMap);

    }
}
