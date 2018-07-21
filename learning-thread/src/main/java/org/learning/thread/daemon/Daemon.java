package org.learning.thread.daemon;

import org.learning.thread.base.SleepUtils;

public class Daemon {
	public static void main(String[] args) {
		System.out.println("I am main.");
		Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
		thread.setDaemon(true);
		thread.start();
	}

	static class DaemonRunner implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println("I am daemon.");
				SleepUtils.second(10);
			} finally {
				System.out.println(" DaemonThread finally run.");
			}
		}
	}
}