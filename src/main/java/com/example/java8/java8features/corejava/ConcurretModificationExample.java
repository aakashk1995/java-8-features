package com.example.java8.java8features.corejava;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;


public class ConcurretModificationExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        ListIterator<String> iterator =  list.listIterator();

        while (iterator.hasNext()){

            if(iterator.next() == ("Apple")){

            }

        }
        //traditional for-loop
        System.out.println(list);
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("Apple");
        copyOnWriteArrayList.add("Banana");
        copyOnWriteArrayList.add("Orange");

        Iterator<String> iterator2 =  copyOnWriteArrayList.listIterator();

        while (iterator2.hasNext()){

            if(iterator2.next() == ("Banana")){
                copyOnWriteArrayList.remove(1);
            }

        }
        System.out.println(copyOnWriteArrayList);

       

    }
}
