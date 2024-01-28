package com.example.java8.java8features.methodreference;

public class BifunctionRef {

    public  int printRef(int a, int b, int c){
       return a+b+c;

    }

    public static void main(String[] args) {
        BifunctionRef bifunctionRef = new BifunctionRef();
         Add add = bifunctionRef::printRef;

        int a = add.addNumbers(12,1,1);
        System.out.println(a);
    }
}
