package org.learning.thread.state;

import org.learning.thread.base.SleepUtils;

public class ThreadState {
	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(), "WaitingThread").start();
		// 使用 两个 Blocked 线程， 一个 获取 锁 成功， 另一个 被 阻塞
		new Thread(new Blocked(), "BlockedThread- 1").start();
		new Thread(new Blocked(), "BlockedThread- 2").start();
	}

	// 该 线程 不断 地 进行 睡眠
	static class TimeWaiting implements Runnable {
		@Override
		public void run() {
			while (true) {
				SleepUtils.second(100);
			}
		}
	}

	// 该 线程 在 Waiting. class 实例 上 等待
	static class Waiting implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	// 该 线程 在 Blocked. class 实例 上 加锁 后， 不会 释放 该 锁
	static class Blocked implements Runnable {
		@Override
		public void run() {
			synchronized (Blocked.class) {
				while (true) {
					SleepUtils.second(100);
				}
			}
		}
	}
}
