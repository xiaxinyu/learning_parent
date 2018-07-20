package org.example.thread.concurrent.timeout;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainTask {
	private int subTaskTimeout = 1500;
	private int mainTaskTimeout = 3;
	private int taskNum = 10;
	private ExecutorService pool;

	private void startMainTask() {
		pool = Executors.newFixedThreadPool(5);
	}

	private void stopMainTask() {
		pool.shutdown();
		try {
			// true if this executor terminated and false if the timeout elapsed before
			// termination
			if (!pool.awaitTermination(mainTaskTimeout, TimeUnit.SECONDS)) {
				pool.shutdownNow();
			}
		} catch (InterruptedException e) {
			pool.shutdownNow();
		}
	}

	private void runSubTasks() throws ApplicationException {
		for (int i = 1; i <= taskNum; i++) {
			Future<Result> future = pool.submit(new SubTask(i));
			try {
				Result result = future.get(subTaskTimeout, TimeUnit.MILLISECONDS);
				System.out.println(result);
			} catch (InterruptedException e) {
				throw new ApplicationException("System error.");
			} catch (ExecutionException e) {
				throw new ApplicationException("System error.");
			} catch (TimeoutException e) {
				throw new ApplicationException("Subtask is timeout.", e);
			}
		}
	}

	public void execute() {
		startMainTask();
		try {
			runSubTasks();
		} catch (ApplicationException e) {
			e.printStackTrace();
			pool.shutdownNow();
		} finally {
			stopMainTask();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new MainTask().execute();
	}
}
