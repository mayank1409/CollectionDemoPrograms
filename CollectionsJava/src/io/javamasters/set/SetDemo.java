package io.javamasters.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
		return name +" ";
	}

	@Override
	public int compareTo(Employee o) {
		return this.getAge().compareTo(o.getAge());
	}
}

public class SetDemo {
	public static void main(String[] args) {
		Set<Employee> employees = new HashSet<>();

		Employee sachin = new Employee(1001, "Sachin", 40);
		Employee dravid = new Employee(1002, "Dravid", 34);
		Employee sehwag = new Employee(1003, "Sehwag", 44);
		Employee ganguly = new Employee(1004, "Ganguly", 54);
		Employee laxman = new Employee(1005, "Laxman", 46);

		employees.add(sehwag);
		employees.add(sachin);
		employees.add(ganguly);
		employees.add(dravid);
		employees.add(laxman);

		// employees.remove(ganguly);

		System.out.print(employees);
		System.out.println(employees.size());

		// employees.clear();
		System.out.println("forEach: ");
		for (Employee employee : employees) {
			System.out.print(employee + "\t");
		}
		System.out.println();
		System.out.println("Iterator: ");
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}
		
		System.out.println();

		Employee gayle = new Employee(2001, "Gayle", 40);
		Employee lara = new Employee(2002, "Lara", 34);
		Employee hopper = new Employee(2003, "Hopper", 44);
		Employee walsh = new Employee(2004, "Walsh", 54);
		Employee ambrose = new Employee(2005, "Ambrose", 46);
		
		Set<Employee> wiemployees = new TreeSet<Employee>(); 
		
		wiemployees.add(ambrose);
		wiemployees.add(hopper);
		wiemployees.add(gayle);
		wiemployees.add(walsh);
		wiemployees.add(lara);
		
		System.out.println(wiemployees);
		
	}
}
