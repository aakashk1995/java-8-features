package com.example.java8.java8features.parallelStreams;

import com.example.java8.java8features.streamapi.dao.EmployeeDao;
import com.example.java8.java8features.streamapi.model.Employee;

import java.util.List;

public class ParellStreamsTest {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeDao.getAllEmployees();

        long start1 = System.currentTimeMillis();
          Double averageSalary=  employeeList.stream().map(Employee::getSalary)
                    .mapToDouble(Double::valueOf).average().getAsDouble();
        System.out.println(averageSalary);
        long end = System.currentTimeMillis();
        System.out.println("Normal Streams take " + (end-start1));

        long start2 = System.currentTimeMillis();
        Double averageSalary2=  employeeList.parallelStream().map(Employee::getSalary)
                .mapToDouble(Double::valueOf).average().getAsDouble();
        System.out.println(averageSalary2);
        long end2 = System.currentTimeMillis();
        System.out.println("Parallel Streams take " + (end2-start2));
    }
}
