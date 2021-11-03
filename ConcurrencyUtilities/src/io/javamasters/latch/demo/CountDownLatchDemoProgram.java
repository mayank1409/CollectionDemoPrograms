package io.javamasters.latch.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchDemoProgram {

	private static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService service = Executors.newFixedThreadPool(3);

		Lock lock = new ReentrantLock();

		/// task 1 add to list 1 to 1000
		service.submit(() -> {

			lock.lock();
			for (int i = 1; i <= 1000; i++) {
				list.add(i);
			}
			latch.countDown();
			lock.unlock();

		});

		//// task 2 add to list 1001 to 2000
		service.submit(() -> {

			lock.lock();
			for (int i = 1001; i <= 2000; i++) {
				list.add(i);
			}
			latch.countDown();
			lock.unlock();
		});
		///// task 3 add to list 2001 to 3000
		service.submit(() -> {
			lock.lock();
			for (int i = 2001; i <= 3000; i++) {
				list.add(i);
			}
			latch.countDown();
			lock.unlock();
		});

		latch.await();

		service.shutdown();
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);

		//// print list size and data
		System.out.println("List size = " + list.size());
		System.out.println("List data = ");
		list.forEach(System.out::println);

		///// print final latch count
		System.out.println("Latch Count :: " + latch.getCount());

	}

}
