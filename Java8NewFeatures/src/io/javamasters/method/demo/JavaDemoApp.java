package io.javamasters.method.demo;

interface Interf {
	default void print() {
		System.out.println("Hello, from default method");
	}
	
	// static method can not be overridden
	public static void display() {
		System.out.println("Hello, from static method");
	}
}

class InterfImpl implements Interf {

	@Override
	public void print() {
		System.out.println("Hello, overriding the default method");
	}
	
}

public class JavaDemoApp {

	public static void main(String[] args) {
		Interf interf = new InterfImpl();
		interf.print();
		// Hello, overriding the default method
		
		Interf.display();
		// Hello, from static method

	}

}
