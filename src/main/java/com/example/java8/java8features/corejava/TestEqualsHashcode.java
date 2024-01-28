package com.example.java8.java8features.corejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEqualsHashcode {
    public static void main(String[] args) {
        Map<Student,String> hmap = new HashMap<>();
        List<String> phoneList = new ArrayList<>();
        phoneList.add("131232131");
        Student studentMain = new Student(1,"aakash","ghatkopar", phoneList);
        Student studentMain2 = new Student(2,"vikas","ghatkopar", phoneList);
        Student studentMain3 = new Student(1,"sakshi","ghatkopar", phoneList);
        Student studentMain4 = new Student(3,"kiran","ghatkopar", phoneList);

        System.out.println(studentMain.equals(studentMain2));
        System.out.println(studentMain.hashCode());
        System.out.println(studentMain2.hashCode());

        hmap.put(studentMain,"dev");
        hmap.put(studentMain2,"electrian");
        hmap.put(studentMain3,"student");
        hmap.put(studentMain4,"staff");

        System.out.println(hmap);

    }
}
