package com.example.java8.java8features.streamapi.dao;

import com.example.java8.java8features.streamapi.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDao {

	public static List<Employee> getEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Roshan", "IT", 600000));
		empList.add(new Employee(2, "Bikash", "CIVIL", 900000));
		empList.add(new Employee(3, "Bimal", "IT", 500000));
		empList.add(new Employee(4, "Sourav", "CORE", 400000));
		empList.add(new Employee(5, "Prakasb", "SOCIAL", 1200000));


		return empList;
	}

	public static List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 1; i <= 600000; i++) {
			employees.add(new Employee(i, "employee" + i, "A", (long) (new Random().nextDouble()*50000)));
		}

		return employees;
	}

}
