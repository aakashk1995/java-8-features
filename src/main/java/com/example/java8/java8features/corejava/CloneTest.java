package com.example.java8.java8features.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CloneTest {
    public static void main(String[] args) {
        List<String> phoneList = new ArrayList<>();
        phoneList.add("131232131");
        phoneList.add("32214123");
        phoneList.add("973231231");
        Student studentMain = new Student(1,"aakash","ghatkopar", phoneList);
        //Student student2 = new Student(1,"aakash","ghatkopar", Arrays.asList("123231","23123123"));
        Student student2 = null;


        List<Student> studentList = new ArrayList<>();
        List<String> trackedPhoneList = new ArrayList<>();
        try {
            for(String phoneNo :studentMain.getPhoneno()){
                System.out.println(phoneNo);
                trackedPhoneList.add(phoneNo);
                Student newStudent = (Student) studentMain.clone();
                newStudent.getPhoneno().retainAll(trackedPhoneList);
                System.out.println(newStudent);
            }

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
//        try {
//            student2 = (Student) studentMain.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }






    }
}
