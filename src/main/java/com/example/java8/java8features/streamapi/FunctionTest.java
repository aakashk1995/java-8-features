package com.example.java8.java8features.streamapi;

import com.example.java8.java8features.streamapi.dao.EmployeeDao;
import com.example.java8.java8features.streamapi.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionTest {

    public static List<String> customMap(List<Employee> employeeList){
        return employeeList.stream().map(Employee::getName).collect(Collectors.toList());
    }

    public static List<String> customMap(Employee employee){
        return new ArrayList<>();
    }

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeDao.getEmployees();

        Function<List,List> function= FunctionTest::customMap;

       List<String> employeName= function.apply(employeeList);
        System.out.println(employeName);
        employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        employeeList.stream().map(FunctionTest::customMap).collect(Collectors.toList());
    }
}
