package com.example.java8.java8features.corejava;

public class ChildAbstract {
   int c;
   int d;
   int a;
   int b;
  ChildAbstract(int c, int d){
      this.c = c;
      this.d = d;
  }
    ChildAbstract(int a, int b,int c, int d) {
        this(c,d);
        this.a = a;
        this.b = b;
    }
}
