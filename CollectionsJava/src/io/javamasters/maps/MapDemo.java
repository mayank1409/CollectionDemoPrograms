package io.javamasters.maps;

import java.util.Map;
import java.util.TreeMap;

class Employee implements Comparable<Employee> {
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

	@Override
	public int compareTo(Employee o) {
		return this.getAge().compareTo(o.getAge());
	}
}

public class MapDemo {
	public static void main(String[] args) {
		Employee sachin = new Employee(1001, "Sachin", 40);
		Employee dravid = new Employee(1002, "Dravid", 34);
		Employee sehwag = new Employee(1003, "Sehwag", 44);
		Employee ganguly = new Employee(1004, "Ganguly", 54);

		Map<Integer, Employee> employees = new TreeMap<>();

		employees.put(ganguly.getId(), ganguly);
		employees.put(dravid.getId(), dravid);
		employees.put(sachin.getId(), sachin);
		employees.put(sehwag.getId(), sehwag);

		System.out.println(employees);
	}
}
