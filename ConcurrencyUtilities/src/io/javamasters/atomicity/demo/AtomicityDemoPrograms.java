package io.javamasters.atomicity.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityDemoPrograms {
	public static void main(String[] args) throws InterruptedException {
		
		//// for atomic int operations
		AtomicInteger atomicInteger = new AtomicInteger(0);
		
		
		///// incrementing in one thread
		Thread t1 = new Thread (() -> {
			for (int i=1; i <=10000; i++) {
				System.out.println("incrementing ");
				atomicInteger.incrementAndGet();
			}
		});
		///// decrementing in second thread
		Thread t2 = new Thread (() -> {
			for (int i=1; i <=10000; i++) {
				System.out.println("decrementing ");
				atomicInteger.decrementAndGet();
			}
		});

		
		t1.start();
		t2.start();
		
		
		///// main thread waits for t1 and t2
		t1.join();  
		t2.join();
		
		System.out.println(atomicInteger.get());
		// 0
	}

}
