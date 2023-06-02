package com.example.java8.java8features.corejava;

class Foo{
    Integer num;

    public Foo(int a){
        this.num = a;
    }
}
public  class PassByValue {
    public static final void main(String[] args) {
        Integer a = 10;
        System.out.println(a);
        a = a+1;
        System.out.println(a);
      //  accept(a);
        System.out.println(a);
        System.out.println("-------------");
        Foo foo = new Foo(1);
        System.out.println(foo.num++);
        Foo foo2 = new Foo(2);
        accept(foo,foo2);
        System.out.println(foo.num);
        System.out.println(foo2.num);

    }
    public static void accept(Integer ab){
        System.out.println(ab);
        ab = 12;
        System.out.println(ab);
    }

    public static void accept(Foo foo, Foo foo2){
       // System.out.println(foo.num);
        foo.num++;
       // System.out.println(foo.num);
        foo2.num = 5;
       // System.out.println(foo2.num);

    }
}
