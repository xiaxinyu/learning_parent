package com.practice.thread.concurrent.sync.task;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task extends Thread {
	private String taskName;
	private CountDownLatch latch;

	public Task(String taskName, CountDownLatch latch) {
		this.taskName = taskName;
		this.latch = latch;
	}

	@Override
	public void run() {
		currentThread().setName(taskName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(currentThread().getName() + " finished self task.");
		latch.countDown();
	}
}

public class AsyncToSyncTask {
	private Integer N = 5;
	private CountDownLatch latch = new CountDownLatch(N);

	public void execute() {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for (int i = 1; i <= N; i++) {
			pool.execute(new Task("SubTask" + i, latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All sub-task finished self task.");
		System.out.println("Main task is going to work now.");
		pool.shutdownNow();
	}
	
	public static void main(String[] args) {
		AsyncToSyncTask mainTask = new AsyncToSyncTask();
		mainTask.execute();
	}
}
