package org.learning.thread.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		// ExecutorService service = Executors.newFixedThreadPool(3);
		// ExecutorService service = Executors.newCachedThreadPool();
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i = 1; i <= 10; i++) {
			final int task = i;
			service.execute(new Runnable() {
				public void run() {
					for (int j = 1; j <= 10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
						}     
						System.out.println(Thread.currentThread().getName() + ":" + j + " is looping in task " + task);
					}
				}
			});
		}
		service.shutdownNow();
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " is excuting task boming");
			}
		}, 6, 2, TimeUnit.SECONDS);
	}
}
