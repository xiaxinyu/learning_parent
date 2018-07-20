package org.learning.concurrent.callback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallbackTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		System.out.println("----程序开始运行----");
		Date date1 = new Date();

		ExecutorService pool = Executors.newFixedThreadPool(5);
		List<Future<String>> list = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++) {
			Future<String> f = pool.submit(new MyCallable(i + " "));
			list.add(f);
		}
		pool.shutdown();
		System.out.println("pool.shutdown");

		for (Future<String> f : list) {
			System.out.println(">>>" + f.get().toString());
		}

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
	}
}

class MyCallable implements Callable<String> {
	private String taskNum;

	MyCallable(String taskNum) {
		this.taskNum = taskNum;
	}

	public String call() throws Exception {
		System.out.println(">>>" + taskNum + "任务启动");
		Date dateTmp1 = new Date();
		Thread.sleep(1000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + "任务终止");
		return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
	}
}