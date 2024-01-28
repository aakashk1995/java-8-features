package com.example.java8.java8features.corejava;

class Main1{

    public static void main(String[] args) {
        AnonymousDemo anonymousDemo = new AnonymousDemo();

    }
}
public class AnonymousDemo {

    Polygon polygon = new Polygon(){
        @Override
        public void display() {
            System.out.println("Inside anonymous the Polygon class");
        }
    };
}

