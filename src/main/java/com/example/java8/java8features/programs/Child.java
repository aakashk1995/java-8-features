package com.example.java8.java8features.programs;

import com.example.java8.java8features.corejava.Parent;

public class Child extends Parent {

   private String education;

    Child(String education){
        super();
        this.education = education;
    }

    Child(String name,int age, String education){
        super(name,age);
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getNameFromParent(){
        return this.getName();
    }


    public static void commonStaticMethod(){
        System.out.println("common static method");
    }
}
