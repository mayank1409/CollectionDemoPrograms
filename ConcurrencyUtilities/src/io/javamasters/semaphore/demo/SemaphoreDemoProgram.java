package io.javamasters.semaphore.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreDemoProgram {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = Executors.newFixedThreadPool(2);
		Semaphore semaphore = new Semaphore(5);
		SharedComputer computer = new SharedComputer(semaphore);

		//// login at computer 5 at once 
		IntStream.rangeClosed(1, 5).forEach(i -> {
			service.submit(() -> {
				try {
					computer.tryLogin();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

		});

		//// call to logout
		///// computer.logout();

		service.shutdown();
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);

		///// get available slots
		System.out.println("Available slots " + computer.getAvailableSlots());

	}
}

class SharedComputer {
	Semaphore semaphore;

	public SharedComputer(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void tryLogin() throws InterruptedException {
		////// acquire the shared computer
		////// permit decremented by 1
		semaphore.acquire();
	}

	public void logout() {
		////// releasing the computer
		////// permit incremented by 1
		semaphore.release();
	}

	public int getAvailableSlots() {
		///// get availability 
		return semaphore.availablePermits();
	}

}