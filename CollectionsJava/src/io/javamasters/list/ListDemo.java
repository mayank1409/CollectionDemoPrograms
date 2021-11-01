package io.javamasters.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
		return "Employee " + name + "]";
	}

	

}

public class ListDemo {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();

		Employee sachin = new Employee(1001, "Sachin", 40);
		Employee dravid = new Employee(1002, "Dravid", 34);
		Employee sehwag = new Employee(1003, "Sehwag", 44);
		Employee ganguly = new Employee(1004, "Ganguly", 54);

		employees.add(sehwag);
		employees.add(sachin);
		employees.add(ganguly);
		employees.add(dravid);
		
		// employees.remove(1);
		// employees.clear();
		
		System.out.println(employees);
		System.out.println(employees.size());
		
		for (Employee employee: employees) {
			System.out.print(employee + "\t");
		}
		System.out.println();
		System.out.println("using iterator: ");
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + "\t");
		}
		System.out.println();
		System.out.println("using listiterator: ");
		ListIterator<Employee> listIterator = employees.listIterator();
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + "\t");
		}
		System.out.println();
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + "\t");
		}

	}
}
