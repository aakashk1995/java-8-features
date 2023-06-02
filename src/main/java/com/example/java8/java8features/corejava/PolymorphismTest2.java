package com.example.java8.java8features.corejava;

class ParentA{
    public void show(){
        System.out.println("From parent");
    }
}
class ChildA extends ParentA{
    public void show(){
        System.out.println("From child");
    }
}
public class PolymorphismTest2 {
    public static void main(String[] args) {
        ParentA a = new ChildA();
        a.show();
    }
}
