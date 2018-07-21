package org.learning.thread.priority;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Job Priority : 1, Count : 5
Job Priority : 1, Count : 6
Job Priority : 1, Count : 4
Job Priority : 1, Count : 3
Job Priority : 1, Count : 5
Job Priority : 10, Count : 52987856
Job Priority : 10, Count : 80598825
Job Priority : 10, Count : 52987801
Job Priority : 10, Count : 80598855
Job Priority : 10, Count : 52987841*/
public class PriorityTest {
	private static volatile boolean notStart = true;
	private static volatile boolean notEnd = true;

	public static void main(String[] args) throws Exception {
		List<Job> jobs = new ArrayList<Job>();
		for (int i = 0; i < 10; i++) {
			int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
			Job job = new Job(priority);
			jobs.add(job);
			Thread thread = new Thread(job, "Thread:" + i);
			thread.setPriority(priority);
			thread.start();
		}
		notStart = false; // 设置统一开始
		TimeUnit.SECONDS.sleep(30); // 设置运行10秒钟
		notEnd = false; // 设置统一结束
		for (Job job : jobs) {
			System.out.println(" Job Priority : " + job.priority + ", Count : " + job.jobCount);
		}
	}

	static class Job implements Runnable {
		private int priority;
		private long jobCount;

		public Job(int priority) {
			this.priority = priority;
		}

		public void run() {
			while (notStart) {
				Thread.yield();
			}
			while (notEnd) {
				Thread.yield();
				jobCount++;
			}
		}
	}
}
