package com.example.java8.java8features.corejava;

class A {
    public void m1(A a){
        System.out.println("m1 method in class A");
    }
}
class B extends A {

    public void m1(B a){
        System.out.println("m1 method in class B accept B");
    }

}


public class PolymorphismTest {
    public static void main(String[] args) {

        A a = new A();
        a.m1(a);
        a.m1(new B());
        A a1 = new B();
        a1.m1(new B());

    }
}
