package io.javamasters.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

class NamedCompator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

class AgedComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge().compareTo(o2.getAge());
	}

}

public class ComparatorDemo {

	public static void main(String[] args) {

		Employee sachin = new Employee(1001, "Sachin", 40);
		Employee dravid = new Employee(1002, "Dravid", 34);
		Employee sehwag = new Employee(1003, "Sehwag", 44);
		Employee ganguly = new Employee(1004, "Ganguly", 54);

		List<Employee> employees = new ArrayList<>();

		employees.add(sehwag);
		employees.add(sachin);
		employees.add(ganguly);
		employees.add(dravid);

		Collections.sort(employees, new NamedCompator());
		System.out.println("Name " + employees);
		// [Employee Dravid], Employee Ganguly], Employee Sachin], Employee Sehwag]]

		Collections.sort(employees, new AgedComparator());
		System.out.println("Age "+ employees);
		// [Employee Dravid], Employee Sachin], Employee Sehwag], Employee Ganguly]]

	}

}
