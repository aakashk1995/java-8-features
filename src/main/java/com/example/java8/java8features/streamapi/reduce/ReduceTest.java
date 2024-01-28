package com.example.java8.java8features.streamapi.reduce;

import com.example.java8.java8features.streamapi.dao.ClassroomDao;
import com.example.java8.java8features.streamapi.model.Classroom;
import com.example.java8.java8features.streamapi.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class ReduceTest {
    public static void main(String[] args) {
      List<Classroom> classroomList=  ClassroomDao.getAllClassroomStudents();
        System.out.println(classroomList.get(0).getStudents().stream()
                        .map(student -> student.getAge())
                        .reduce(0,(partialAge,age)->(partialAge+age))

                );

        System.out.println(classroomList.get(0).getStudents().stream().map(student ->
                student.getAge()).collect(Collectors.toList()).stream()
                .mapToInt(Integer::intValue).sum());

        System.out.println(classroomList.get(0).getStudents().stream()
                .mapToDouble(Student::getAge).average());


    }
}
