package io.javamasters.multiinheritance.demo;

interface Left {
	default void left() {
		System.out.println("Hello, from left");
	}
}

interface Right {
	default void right() {
		System.out.println("Hello, from right");
	}
}

//// center is exhibiting multiple inheritance
interface Center extends Left, Right {

	@Override
	default void right() {
		System.out.println("Center Overriding the Right");
		
		//// calling the default right
		Right.super.right();
	}

	@Override
	default void left() {
		System.out.println(" Center Overriding the Left");
		
		//// calling the default left
		Left.super.left();
	}
}

///// MIImpl is exhibiting multiple inheritance
class MIImpl implements Left, Right {

	@Override
	public void right() {
		System.out.println("MIImpl Overriding the Right");
		
		//// calling the default right
		Right.super.right();
	}

	@Override
	public void left() {
		System.out.println("MIImpl Overriding the Left");
		
		//// calling the default left
		Left.super.left();
	}

}

public class JavaDemoApp {
	public static void main(String[] args) {
		Left left = new MIImpl();
		Right right = new MIImpl();

		left.left();
		right.right();
		
	}
}
