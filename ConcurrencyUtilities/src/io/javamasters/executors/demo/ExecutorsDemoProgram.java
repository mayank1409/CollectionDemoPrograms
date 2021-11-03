package io.javamasters.executors.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemoProgram {

	public static void main(String[] args) throws InterruptedException {

		// using single pool executor
		ExecutorService service = Executors.newSingleThreadExecutor();

		
		//// usage of future
		Future<List<Long>> result = service.submit(new Callable<List<Long>>() {
			@Override
			public List<Long> call() throws Exception {
				int n = 5;
				// calculate factorial of each i from 1 to n=5 
				List<Long> factorials = new ArrayList<Long>();
				for (int i = 1; i <= n; i++) {
					System.out.println("i = " + i);
					factorials.add(calcFact(i));
				}
				return factorials;
			}
		});

		service.shutdown();

		service.awaitTermination(10, TimeUnit.SECONDS);

		try {
			
			/// usage of future get
			List<Long> list = result.get();
			if (list != null && !list.isEmpty())
				list.forEach(System.out::println);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	public static Long calcFact(int i) {
		if (i <= 1) {
			return 1l;
		}
		return calcFact(i - 1) * i;
	}
}
