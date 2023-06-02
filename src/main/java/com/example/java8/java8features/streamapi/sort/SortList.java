package com.example.java8.java8features.streamapi.sort;

import com.example.java8.java8features.streamapi.dao.EmployeeDao;
import com.example.java8.java8features.streamapi.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SortList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Dell");
        list.add("Apple");
        list.add("Lenovo");
        list.add("Microsoft");

       List<Employee> employeeList = EmployeeDao.getEmployees();
        System.out.println(employeeList);
        employeeList.stream()
                .sorted((e1,e2)-> e1.getName().compareTo(e2.getName()) )
                .forEach(System.out::println);
        System.out.println("-----------------------------------");
        employeeList.stream()
                .filter(employee -> !employee.getDept().equalsIgnoreCase("IT"))
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .limit(2)
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Comparator.comparing(Employee::getName)))
                .forEach(System.out::println);

        System.out.println("----------comparing salary with reversed------------------------");

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
        System.out.println("--------------max salary---------------");
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(1)
                .forEach(System.out::println);

      Employee employeeStreamReduce =  employeeList.stream()
                .reduce((employee, employee2) -> employee.getSalary() > employee2.getSalary() ? employee :employee2)
                .get();

      employeeList.stream()
                      .mapToInt(Employee::getId)
                              .max();



        System.out.println(employeeStreamReduce);



    }
}
