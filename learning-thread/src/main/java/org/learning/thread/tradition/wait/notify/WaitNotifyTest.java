package org.learning.thread.tradition.wait.notify;

public class WaitNotifyTest {
	private static Output out = new Output();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					out.printInSubThread();
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					out.printInMainThread();
				}
			}
		}).start();
	}
}

class Output {
	private boolean lockedSub = false;

	public synchronized void printInSubThread() {
		if (lockedSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			System.out.println("SubThread output " + i);
		}
		lockedSub = true;
		this.notify();
	}

	public synchronized void printInMainThread() {
		if (!lockedSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			System.out.println("MainThread output " + i);
		}
		lockedSub = false;
		this.notify();
	}
}