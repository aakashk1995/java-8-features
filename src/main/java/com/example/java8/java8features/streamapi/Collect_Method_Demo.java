package com.example.java8.java8features.streamapi;

import com.example.java8.java8features.streamapi.map_flatmap.Customer;
import com.example.java8.java8features.streamapi.map_flatmap.CustomerDao;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Collect Elements of a Stream into a Collection.
 * 
 * Elements from a Stream can be easily collected into
 * a container by using the Stream.collect operation.
 * 
 * Now After getting container it can be converted into 
 * Other Collection instances, such as a List,Set,Map etc.
 * can be made by using other Collectors built-in methods
 * 
 * Collectors.toList()
 * Collectors.toSet()
 * Collectors.toMap()
 * */
public class Collect_Method_Demo {

	public static void main(String[] args) {
		System.out.println(Arrays.asList("apple", "banana", "banana", "kiwi", "orange").stream()
				.filter(fruit -> fruit.startsWith("a")).collect(Collectors.toList()));
		// [apple, banana, banana, orange]

		System.out.println(Arrays.asList("apple", "banana", "banana", "kiwi", "orange").stream()
				.filter(fruit -> fruit.contains("a")).collect(Collectors.joining(",")));

		// [banana, orange, apple]

		System.out.println(Arrays.asList("apple", "banana", "banana", "kiwi", "orange").stream()
				.filter(fruit -> fruit.contains("a")).collect(Collectors.toSet()));

		System.out.println("------------grouping by-----------");
		List<Customer> customers = CustomerDao.getAllCustomers();

		Map<Integer, Set<Customer>> integerListMap= customers.stream().collect(Collectors.groupingBy(Customer::getId,Collectors.toSet()));
		System.out.println(integerListMap);

		System.out.println("------------summation-----------");

		Map<Integer,Double> summIntegrIntegerMap =
		customers.stream().collect(Collectors.groupingBy(Customer::getId,Collectors.summingDouble(Customer::getSalary)));
		System.out.println(summIntegrIntegerMap);
		System.out.println("------------counting-----------");
		Map<Integer,Long> countIntegerDoubleMap =
				customers.stream().collect(Collectors.groupingBy(Customer::getId,Collectors.counting()));
		System.out.println(countIntegerDoubleMap);

		System.out.println("------------Min && Max -----------");
		Map<Integer, Optional<Customer>> maxIntegerLongMap =
				customers.stream().collect(Collectors.groupingBy(Customer::getId,Collectors.maxBy(Comparator.comparing(Customer::getSalary))));
		System.out.println(maxIntegerLongMap);

		System.out.println("------------Min && Max -----------");
		Map<Integer, Optional<Customer>> minIntegerLongMap =
				customers.stream().collect(Collectors.groupingBy(Customer::getId,Collectors.minBy(Comparator.comparing(Customer::getSalary))));
		System.out.println(minIntegerLongMap);


	}

}
