package org.learning.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore（信号量） 是用来控制同时访问特定资源的线程数量， 它通过协调各个线程， 以保证 合理的使用公共资源。
 */
public class SemaphoreTest {
	private static final int THREAD_COUNT = 30;
	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
	//虽然有30个线程在执行， 但是只允许10个并发执行。
	private static Semaphore s = new Semaphore(10);

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println("[" + Thread.currentThread().getName() + "] save data");
						s.release();
					} catch (InterruptedException e) {
					}
				}
			});
		}
		threadPool.shutdown();
	}
}