package com.example.java8.java8features.corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Any Entity
public class  Student implements Cloneable {

    private int studentid;  //fields, attributes

    private String name;

    private String address;

    private List<String> phoneno;

    public Student(int studentid, String name, String address, List<String> phoneno) {
        this.studentid = studentid;
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
    }

    public Student(){

    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneno(List<String> phoneno) {
        this.phoneno = phoneno;
    }

    public int getStudentid() {
        return studentid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getPhoneno() {
        return phoneno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneno=" + phoneno +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.phoneno = new ArrayList<>(this.phoneno);
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentid == student.studentid && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(phoneno, student.phoneno);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(studentid, name, address, phoneno);
//    }
}
