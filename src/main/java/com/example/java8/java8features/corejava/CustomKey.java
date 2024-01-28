package com.example.java8.java8features.corejava;

import java.util.Objects;

public class CustomKey {

    private int id;

    private String name;

    public CustomKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomKey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomKey customKey = (CustomKey) o;
        return id == customKey.id && name.equals(customKey.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public static void main(String[] args) {
        CustomKey customKey = new CustomKey(1,"aakash");
        CustomKey customKey2 = new CustomKey(1,"aakashE");

        System.out.println(customKey.equals(customKey2));
        System.out.println(customKey.hashCode());
        System.out.println(customKey2.hashCode());
    }
}
