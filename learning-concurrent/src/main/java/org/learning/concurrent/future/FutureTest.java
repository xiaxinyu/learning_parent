package org.learning.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<String> future = pool.submit(new Callable<String>() {
			public String call() throws Exception {
				Thread.sleep(800);
				return Thread.currentThread().getName();
			}
		});

		try {
			System.out.println("Get second return value: " + future.get(1, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("time out");
		}

		pool.shutdown();
	}
}
