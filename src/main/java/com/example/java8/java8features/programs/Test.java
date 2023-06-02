package com.example.java8.java8features.programs;

import com.example.java8.java8features.corejava.Parent;

class Test {
    static final String str ;
    Test(String str){
        //this.str= str;
        System.out.println("inside constructor");
    }
    {
        //str="string";
        System.out.println("inside instance block");
    }
    static {
        str="static string";
        System.out.println("inside static block");
    }
    String testName = "aakash";
    public static void main(String[] args) {
        Child child = new Child("Aakash",28,"engineer");
        System.out.println(child.getEducation());
        System.out.println(child.getNameFromParent());
        System.out.println(child.getAge());
        System.out.println(child.getEducation());

        Parent parent = new Parent("vikas",56);
        System.out.println(parent.getAge());
       // new Test("aabcc");

    }
    public void test(){
        System.out.println(testName);
        final String a = "aakash";
        System.out.println(str);
    }
}
