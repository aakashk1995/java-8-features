package com.example.java8.java8features.corejava;

public class Implementation implements InterfaceDemo {


    @Override
    public void testA() {
        InterfaceDemo.staticMethod();

    }

    @Override
    public void defaultMethod() {
        InterfaceDemo.super.defaultMethod();
    }

    @Override
    public void defaultMethod2() {
        InterfaceDemo.super.defaultMethod2();
    }
}
