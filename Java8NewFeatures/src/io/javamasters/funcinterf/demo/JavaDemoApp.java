package io.javamasters.funcinterf.demo;

@FunctionalInterface
interface Calculate {

	public int calculate(int x, int y, String operation);
}

public class JavaDemoApp {

	public static void main(String[] args) {
		
		// giving the implementation of functional 
		// interface using the lambda expression
		Calculate result = (a, b, operation) -> {
			switch (operation) {
			case "ADD":
				return a + b;
			case "SUBTRACT":
				int sub = a > b ? (a - b) : (b - a);
				return sub;
			case "MULTIPLY":
				return a * b;
			case "MOD":
				return a % b;
			default:
				return 0;
			}
		};
		
		System.out.println("10 + 20 = " + result.calculate(10, 20, "ADD"));
		System.out.println("|10 - 20 | = " + result.calculate(10, 20, "SUBTRACT"));
		System.out.println("10 * 20 = " + result.calculate(10, 20, "MULTIPLY"));
		System.out.println("10 % 20 = " + result.calculate(10, 20, "MOD"));
//		10 + 20 = 30
//		|10 - 20 | = 10
//		10 * 20 = 200
//		10 % 20 = 10
		
		
		// implementing runnable using lambda
		Runnable r = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for (int i=1; i<=10; i++) {
				System.out.println("Hello, from child thread");
			}
		};
		
		Thread t1 = new Thread(r);
		t1.start();

	}

}
