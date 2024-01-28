package com.example.java8.java8features.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightShiftArray {

    public static void leftShiftUsingCircularArray(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int index = 2,k=2;
        int[] result = new int[arr.length];
        CircularArray sourceIndex = new CircularArray(arr.length);
        sourceIndex.setLeftStart(index);

        CircularArray targetIndex = new CircularArray(arr.length);
        targetIndex.setLeftStart(index-k);

        for(int i=0;i<arr.length;i++){
            int newindex = sourceIndex.nextLeft();
            int targetindex = targetIndex.nextLeft();

             System.out.println("New index " + newindex + " Target index " + targetindex);
            result[targetindex] = arr[newindex];
        }
        for(int a: result)
            System.out.print(a + " ");

    }

    public static void rightShiftUsingCircularArray(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int index = 2,k=3;
        int[] result = new int[arr.length];
        CircularArray sourceIndex = new CircularArray(arr.length);
        sourceIndex.setStart(index);
      //  sourceIndex.start = index;

        CircularArray targetIndex = new CircularArray(arr.length);
        targetIndex.setStart(index+k);
      //  targetIndex.start = index+k;


        for(int i=0;i<arr.length;i++){
            int newindex = sourceIndex.nextRight();
            int targetindex = targetIndex.nextRight();

           // System.out.println("New index " + newindex + " Target index " + targetindex);
            result[targetindex] = arr[newindex];
        }
        for(int a: result)
            System.out.print(a + " ");

    }

    public static void leftShift(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //           3  4  5  6  7  1  2
        //           4  5  6  7  1  2  3
        int n=6,k=2;
        int index = 1;
        int[] result = new int[arr.length];
        for(int i=0,p=index;i<index-1;i++,p--){
            result[p-k] = arr[p];
        }
        for(int i : result)
            System.out.println(i);
    }
    public static void main(String[] args) {
        //rightShiftUsingCircularArray();
        System.out.println();
        leftShiftUsingCircularArray();
        //  leftShift();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //           6  7  1  2  3  4  5
        //           3  4  5  6  7  1  2
        int n = 3,k=2;
        //index = 2
        // 6 7 1 2 3 4 5

//        int[] result = new int[arr.length];
//
//        for(int i=0;i<k;i++){
//            result[i] = arr[arr.length+k-i];
//        }
//        for(int i=k,j=0;i<arr.length;i++,j++){
//            result[i] = arr[j];
//        }
       // for(int i : result)
           // System.out.println(i);


    }
}









