package io.javamasters.locks.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LocksDemoProgram {

	static int x;

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Lock lock = new ReentrantLock();

		IntStream.rangeClosed(1, 10000).forEach(i -> {

			executorService.submit(() -> {
				
				//// locking
				lock.lock();
				increment();
				//// unlocking
				lock.unlock();
			});
		});

		executorService.shutdown();
		executorService.awaitTermination(100, TimeUnit.MILLISECONDS);

		System.out.println(x);

	}

	private static void increment() {
		x++;
	}

}
