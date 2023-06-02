package com.example.java8.java8features.streamapi.model;

import java.util.List;

public class Classroom {
    private int numberOfStudents;
    private List<Student> students;

    public Classroom(int numberOfStudents, List<Student> students) {
        this.numberOfStudents = numberOfStudents;
        this.students = students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "numberOfStudents=" + numberOfStudents +
                ", students=" + students +
                '}';
    }
}
