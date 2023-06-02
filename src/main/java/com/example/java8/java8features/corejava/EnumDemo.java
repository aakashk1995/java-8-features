package com.example.java8.java8features.corejava;

import javax.xml.datatype.DatatypeConstants;

enum PersonName {

    AAKASH("AAKASH","28", DatatypeConstants.AUGUST),
    SAKSHI("SAKSHI","18", DatatypeConstants.JANUARY);

    private String name;
    private String age;
    private int month;
    PersonName(String name1, String age, int month) {

        this.name = name1;
        this.age = age;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getMonth() {
        return month;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
     //   System.out.println(PersonName.AAKASH.getAge());
     //   System.out.println(PersonName.AAKASH.getMonth());
       Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.totalMemory());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.freeMemory());
        PersonName[] personNames= PersonName.values();
       for(PersonName personName: personNames){
           System.out.println(personName.getName());
       }
        System.gc();
        System.out.println(runtime.freeMemory());


    }
}
