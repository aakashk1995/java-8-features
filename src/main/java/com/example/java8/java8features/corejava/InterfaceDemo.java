package com.example.java8.java8features.corejava;

public interface InterfaceDemo {
   static final int a =10;
    void testA();

    public static void staticMethod() {
        System.out.println("static methods");
        System.out.println(a);
       // privateMethod();
    }
    public default void defaultMethod(){
        System.out.println("default method 1");
        System.out.println(a);
    }
    public default void defaultMethod2(){
        System.out.println("default method 2");
        System.out.println(a);
       // privateMethod();
    }

//    private static void privateMethod(){
//        System.out.println("private Method");
//    }
}
