package com.example.java8.java8features.corejava;

 interface DemoInterface1  {

    final int a = 5;

    default void display() {
        System.out.println("Demo Interface 1");
    }

}

interface DemoInterface2  {

    default void display() {
        System.out.println("Demo Interface 2");
    }
}



public class DefaultInterfaceTest implements DemoInterface1,DemoInterface2{


    @Override
    public void display() {
        DemoInterface2.super.display();
    }

    public static void main(String[] args) {
        new DefaultInterfaceTest().display();
    }
}
