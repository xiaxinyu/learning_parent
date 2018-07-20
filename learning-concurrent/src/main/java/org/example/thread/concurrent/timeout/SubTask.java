package org.example.thread.concurrent.timeout;

import java.util.concurrent.Callable;

public class SubTask implements Callable<Result> {
	private int taskSequence;

	public SubTask(int taskSequence) {
		this.taskSequence = taskSequence;
	}

	public Result call() throws Exception {
		long limit = Counter.getLimit();
		long start = System.currentTimeMillis();
		long result = Counter.calc(limit);
		long end = System.currentTimeMillis();
		return new Result(taskSequence, limit, result, (end - start));
	}
}
