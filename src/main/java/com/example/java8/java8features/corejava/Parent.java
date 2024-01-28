package com.example.java8.java8features.corejava;

public class Parent {
    String name;
    int age;

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Parent() {

    }


    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void commonStaticMethod(){
        System.out.println("common static method");
    }

    public void parentMethod(){
        System.out.println("I'm inside parent method");
    }
}
