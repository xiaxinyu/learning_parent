package org.learning.thread.interrupte;

import java.util.concurrent.TimeUnit;

import org.learning.thread.base.SleepUtils;

public class Interrupted {
	public static void main(String[] args) throws Exception {
		// sleepThread 不停 的 尝试 睡眠
		Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
		sleepThread.setDaemon(true);
		// busyThread 不停 的 运行
		Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
		busyThread.setDaemon(true);
		sleepThread.start();
		busyThread.start();
		// 休眠 5 秒， 让 sleepThread 和 busyThread 充分 运行
		TimeUnit.SECONDS.sleep(5);
		sleepThread.interrupt();
		busyThread.interrupt();

		System.out.println(" SleepThread interrupted is " + sleepThread.isInterrupted());
		System.out.println(" BusyThread interrupted is " + busyThread.isInterrupted());
		// 防止 sleepThread 和 busyThread 立刻 退出
		SleepUtils.second(2);
	}

	static class SleepRunner implements Runnable {
		@Override
		public void run() {
			while (true) {
				SleepUtils.second(10);
			}
		}
	}

	static class BusyRunner implements Runnable {
		@Override
		public void run() {
			while (true) {
			}
		}
	}
}
