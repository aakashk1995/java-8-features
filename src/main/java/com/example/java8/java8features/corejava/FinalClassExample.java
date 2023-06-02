package com.example.java8.java8features.corejava;

import java.util.HashMap;
import java.util.Map;

public class FinalClassExample {
    // fields of the FinalClassExample class
    private final int id;

    private final String name;

    private final HashMap<String,String> testMap;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Getter function for mutable objects

    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();
    }

    //Constructor method performing deep cloning
    public FinalClassExample(int i, String n, HashMap<String,String> hm){
        System.out.println("Performing Shallow Copy for Object initialization");
        this.id=i;
        this.name=n;
        //perform deep cloning
        HashMap<String,String> hashMap = new HashMap<>();
        for(Map.Entry<String,String> entry :  hm.entrySet()){
            hashMap.put(entry.getKey(), entry.getValue());
        }
        this.testMap=hashMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String,String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i=10;
        FinalClassExample ce = new FinalClassExample(i,s,h1);

        // print the ce values
        System.out.println("ce id: "+ce.getId());
        System.out.println("ce name: "+ce.getName());
        System.out.println("ce testMap: "+ce.getTestMap());

        // change the local variable values
        i=20;
        s="modified";
        h1.put("3", "third");

        // print the values again
        System.out.println("ce id after local variable change: "+ce.getId());
        System.out.println("ce name after local variable change: "+ce.getName());
        System.out.println("ce testMap after local variable change: "+ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from getter methods: "+ce.getTestMap());
    }

}
