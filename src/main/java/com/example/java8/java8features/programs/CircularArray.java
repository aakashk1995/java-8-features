package com.example.java8.java8features.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CircularArray {

    int[] array;

   int start;
    int size;

    CircularArray(int size){
        this.size = size;
        this.array = new int[size*2];
        for(int i=0;i<size;i++) {
                array[i] = i;
        }
        for(int j=size,i=0;j<size*2;j++,i++){
            array[j] = i;
        }

    }
    public int nextRight(){
        int number = this.array[start];
        start++;
       return number;
    }

    public int nextLeft(){
        int number = this.array[this.start];
        this.start--;
        return number;
    }

    public void setLeftStart(int startcounter){
        if(startcounter<0)
         startcounter = size+(startcounter);

        List<Integer> list = Arrays.stream(this.array)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        this.start = list.lastIndexOf(startcounter);
    }

    public void setStart(int startcounter){
        List<Integer> list = Arrays.stream(this.array)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        this.start = list.indexOf(startcounter);
    }

    public static void main(String[] args) {
        CircularArray circularArray = new CircularArray(7);
        circularArray.setLeftStart(-1);


        for(int a : circularArray.array){
            System.out.println(a);
        }
        System.out.println("next left numbers");

        System.out.println(circularArray.nextLeft());
        System.out.println(circularArray.nextLeft());
        System.out.println(circularArray.nextLeft());
        System.out.println(circularArray.nextLeft());
        System.out.println(circularArray.nextLeft());
        System.out.println(circularArray.nextLeft());
        System.out.println(circularArray.nextLeft());


    }

}
