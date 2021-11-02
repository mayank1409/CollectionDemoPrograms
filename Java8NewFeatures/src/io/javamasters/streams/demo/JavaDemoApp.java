package io.javamasters.streams.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
	private int id;
	private String name;
	private Integer age;

	public Employee() {
	}

	public Employee(int id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " ";
	}

}

public class JavaDemoApp {

	public static void main(String[] args) {

		System.out.println(IntStream.rangeClosed(1, 10).sum()); /// 55
		System.out.println(IntStream.rangeClosed(1, 9999).count()); /// 9999
		System.out.println(IntStream.rangeClosed(1, 9999).average().getAsDouble()); /// 5000.0
		System.out.println(IntStream.rangeClosed(1, 9999).max().getAsInt()); /// 9999

		Employee sachin = new Employee(1001, "Sachin", 40);
		Employee dravid = new Employee(1002, "Dravid", 34);
		Employee sehwag = new Employee(1003, "Sehwag", 44);
		Employee ganguly = new Employee(1004, "Ganguly", 54);
		Employee gavaskar = new Employee(1005, "Gavaskar", 64);
		Employee kapil = new Employee(1006, "Kapil", 65);
		Employee ravi = new Employee(1007, "Ravi", 60);
		Employee dhoni = new Employee(1008, "Dhoni", 40);
		Employee zaheer = new Employee(1009, "Zaheer", 40);
		Employee srinath = new Employee(1010, "Srinath", 40);

		List<Employee> employees = new ArrayList<>();

		employees.add(sehwag);
		employees.add(sachin);
		employees.add(ganguly);
		employees.add(dravid);
		employees.add(gavaskar);
		employees.add(kapil);
		employees.add(ravi);
		employees.add(dhoni);
		employees.add(zaheer);
		employees.add(srinath);

		// iterating using forEach java 8 way
		employees.forEach(System.out::print);
		System.out.println();

		// iterating using stream for each
		employees.stream().forEach(employee -> System.out.print(employee));

		System.out.println();

		// iterating using iterator
		Iterator<Employee> empIterator = employees.stream().iterator();
		while (empIterator.hasNext()) {
			System.out.print(empIterator.next());
		}

		System.out.println();

		//// skip 4 employees
		List<Employee> skippdEmployees = employees.stream().skip(4).collect(Collectors.toList());
		skippdEmployees.forEach(System.out::print);
		System.out.println();

		/// skip and limit
		List<Employee> skipAndLimit = employees.stream().skip(4).limit(3).collect(Collectors.toList());
		skipAndLimit.forEach(System.out::print);
		System.out.println();

		//// using count

		System.out.print("count of employees age > 50 is ");
		// count number of employees age > 50
		System.out.println(employees.stream().filter(employee -> employee.getAge() > 50).count());

		// usage of find first
		Employee emp = employees.stream().filter(employee -> employee.getAge() > 50).findFirst().get();
		System.out.println(emp);

		// usage of find any
		Employee emp2 = employees.stream().filter(employee -> employee.getAge() > 50).findAny().get();
		System.out.println(emp2);

		// employee with max age
		Optional<Employee> max = employees.stream().filter(employee -> employee.getAge() > 50)
				.max(Comparator.comparing(Employee::getAge));
		System.out.println("Employee with max age " + max.get());

		////////////////////////////////

		//////// sorting a list based on conditions
		System.out.print("Sorting reverse order based on name :: ");
		// sort the employees based on age
		Comparator<Employee> reverseComparator = (e1, e2) -> {
			return e1.getName().compareTo(e2.getName());
		};
		Collections.sort(employees, reverseComparator.reversed());
		employees.forEach(System.out::print);

		System.out.println();

		System.out.print("Sorting based on Age :: ");
		// sort the employees based on age
		Collections.sort(employees, Comparator.comparing(Employee::getAge));
		employees.forEach(System.out::print);

		System.out.println();

		System.out.print("Sorting based on Name :: ");
		// sort the employees based on name
		Collections.sort(employees, Comparator.comparing(Employee::getName));
		employees.forEach(System.out::print);
		System.out.println();

		// sorting with multiple conditions
		System.out.print("Sorting with multiple conditions :: ");
		Collections.sort(employees,
				Comparator.comparing(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName)));
		employees.forEach(System.out::print);

		System.out.println();

		System.out.print("Sorting based on reverse age :: ");
		// using sorted method
		employees = employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed())
				.collect(Collectors.toList());
		employees.forEach(System.out::print);
		System.out.println();

		///////////////////////////////

		/////// usage of map
		List<Integer> mapped = employees.stream().map(employee -> employee.getAge()).collect(Collectors.toList());
		System.out.println("Age of employees :: " + mapped);

		//// usage of flatMap
		List<List<Employee>> listOfList = Arrays
				.asList(Arrays.asList(new Employee(1011, "Kohli", 23), new Employee(1012, "Rohit", 32)));
		List<Employee> flattenEmployees = listOfList.stream().flatMap(Collection::stream).collect(Collectors.toList());
		flattenEmployees.forEach(System.out::print);

		System.out.println();

		/////////////// MAP Objects

		Map<Integer, Employee> employeesMap = new HashMap<Integer, Employee>();

		employeesMap.put(sachin.getId(), sachin);
		employeesMap.put(dravid.getId(), dravid);
		employeesMap.put(sehwag.getId(), sehwag);
		employeesMap.put(ganguly.getId(), ganguly);
		employeesMap.put(gavaskar.getId(), gavaskar);
		employeesMap.put(kapil.getId(), kapil);
		employeesMap.put(ravi.getId(), ravi);
		employeesMap.put(dhoni.getId(), dhoni);
		employeesMap.put(zaheer.getId(), zaheer);
		employeesMap.put(srinath.getId(), srinath);

		/// iterating over the keys
		employeesMap.keySet().forEach(System.out::println);

		//// iterating over the values
		employeesMap.values().forEach(System.out::println);

		///// iterating over the entry set
		employeesMap.entrySet().forEach(System.out::println);

		/////
		System.out.println("count employees age > 50 is "
				+ employeesMap.values().stream().filter(value -> value.getAge() > 50).count());

		List<Employee> skipAndLimitMap = employeesMap.values().stream().skip(3).limit(4).collect(Collectors.toList());
		skipAndLimitMap.forEach(System.out::print);

		System.out.println();

		////////// sort

		List<Employee> empRevSortByAge = employeesMap.values().stream()
				.sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
		empRevSortByAge.forEach(System.out::print);

		System.out.println();

		List<Employee> empRevSortByAgeAndByName = employeesMap.values().stream().sorted(Comparator
				.comparing(Employee::getAge).reversed().thenComparing(Comparator.comparing(Employee::getName)))
				.collect(Collectors.toList());
		empRevSortByAgeAndByName.forEach(System.out::print);
		System.out.println();

		/////// convert mao to list by filtering name starts with D
		List<Employee> empNameNotStartsWithD = employeesMap.values().stream().filter(d -> !d.getName().startsWith("D"))
				.collect(Collectors.toList());
		empNameNotStartsWithD.forEach(System.out::print);
		System.out.println();

		////// convert list to map
		Map<Integer, String> convertedListToMap = employees.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getName, (o, n) -> o));
		convertedListToMap.entrySet().forEach(System.out::println);
		
		System.out.println();

	}

}
