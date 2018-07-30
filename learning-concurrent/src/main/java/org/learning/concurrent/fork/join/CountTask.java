package org.learning.concurrent.fork.join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class CountTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 2;
	// 阈值
	private int start;
	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// 如果 任务 足够 小 就 计算 任务
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// 如果 任务 大于 阈值， 就 分裂 成 两个 子 任务 计算
			int middle = (start + end) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			// 执行 子 任务
			leftTask.fork();
			rightTask.fork();
			// 等待 子 任务 执行 完， 并 得到 其 结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			// 合并 子 任务
			sum = leftResult + rightResult;
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		// 生成 一个 计算 任务， 负责 计算 1+ 2+ 3+ 4
		CountTask task = new CountTask(1, 1000000);
		// 执行 一个 任务
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {

		} catch (ExecutionException e) {

		}
	}
}
