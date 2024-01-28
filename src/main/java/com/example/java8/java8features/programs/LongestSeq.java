package com.example.java8.java8features.programs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class LongestSeq {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,1,4,200,3,2);

        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Integer i : list){
            treeSet.add(i);
        }
        int index = 0;
        Object[] array = treeSet.toArray();
        for(int i = 0,j=1;i<array.length;i++,j++){
            int a = (int) array[i];
            int b = (int) array[j];
            if(b == a+1){
                System.out.println(array[i]);
                continue;
            }else{
                index = i;
                break;
            }
        }
        System.out.println(array[index]);
       int a = 11;
       int b = 1;
       int c = a+b;
        System.out.println(Integer.toBinaryString(c));
    }
}
