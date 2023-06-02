package com.example.java8.java8features.streamapi.sort;

import com.example.java8.java8features.streamapi.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSort {
    static  Map<String,Long> customMap = new HashMap<>();
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("eight", 8);
        map.put("four", 4);
        map.put("ten", 10);
        map.put("two", 2);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        Map<Employee, Integer> employeeMap = new HashMap<>();
        employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
        employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
        employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
        employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
        employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);
        employeeMap.put(null, 120);
        employeeMap.put(new Employee(781, "Prakash", null, 450000), 58);
        employeeMap.put(new Employee(782, "Prakash", null, 1480000), 58);
        //List<Map.Entry<Employee, Integer>> mapList =
                employeeMap.entrySet().stream()
                        .filter(employeeIntegerEntry -> employeeIntegerEntry.getKey()!=null)
                    .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getId)))
                    .forEach(System.out::println);
        System.out.println("----------------------");
                 employeeMap.entrySet().stream()
                         .filter(employeeIntegerEntry -> employeeIntegerEntry.getKey()!=null)
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(employeeIntegerEntry -> employeeIntegerEntry.getKey().getName())
                         .forEach(System.out::println);

        System.out.println("------------------------");
        employeeMap.entrySet().stream()
                .filter(employeeIntegerEntry -> employeeIntegerEntry.getKey()!=null)
                .sorted(Map.Entry.comparingByKey(Comparator.nullsFirst(Comparator.comparing(Employee::getId))))
                .forEach(System.out::println);

        System.out.println("----------------------------");
       Map<String,Long> stringLongMap=
            employeeMap.entrySet().stream()
                .filter(employeeIntegerEntry -> employeeIntegerEntry.getKey()!=null)
                . sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getId)))
                .map(employeeIntegerEntry -> employeeIntegerEntry.getKey())
               .collect(Collectors.toMap(Employee::getName,Employee::getSalary,(aLong, aLong2) -> aLong2))
               ;

        System.out.println(stringLongMap);


//        map.entrySet().stream()
//                .filter((entry) -> entry.getValue().equals(2))
//                .map(entry -> entry.getValue())
//                .forEach(System.out::println);

    }

    public static void toMap(Stream<Employee> employeeStream){


    }
}
