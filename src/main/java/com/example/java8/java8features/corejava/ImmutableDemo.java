package com.example.java8.java8features.corejava;

import java.util.HashMap;
import java.util.Iterator;

public final class ImmutableDemo {

    private final String word;

    private final HashMap<String,String> testMap;

    public ImmutableDemo(String word, HashMap<String, String> testMap) {
        this.word = word;
        HashMap<String,String> tempMap=new HashMap<String,String>();
        String key;
        Iterator<String> it = testMap.keySet().iterator();
        while(it.hasNext()){
            key=it.next();
            tempMap.put(key, testMap.get(key));
        }
        this.testMap=tempMap;

    }

    public String getWord() {
        return word;
    }

    public HashMap<String, String> getTestMap() {
        return this.testMap;
    }
}
class TestImmutable{
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String,String>();
        h1.put("1", "first");
        h1.put("2", "second");
        ImmutableDemo immutableDemo = new ImmutableDemo("aakash",h1);
        System.out.println(immutableDemo.getWord());
        System.out.println(immutableDemo.getTestMap());
        HashMap<String, String> h2 = (HashMap<String, String>) h1.clone();
        //h1.put("1","modifiy");

        System.out.println(immutableDemo.getTestMap());
        System.out.println(h1==h2);
        System.out.println(h1.equals(h2));


    }
}