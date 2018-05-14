package org.learning.thread.tradition.wait.notify;

public class WaitNotifyTest {
	public static void main(String[] args) throws InterruptedException {
		Output op = new Output();
		new Thread(new Runnable() {
			public void run() {
				op.printInSubThread();
			}
		}).start();

		Thread.sleep(3000);
		
		new Thread(new Runnable() {
			public void run() {
				op.printInMainThread();
			}
		}).start();
	}
}

class Output {
	public synchronized void printInMainThread() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			System.out.println("MainThread output " + i);
		}
		this.notify();
	}

	public synchronized void printInSubThread() {
		if (true) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			System.out.println("SubThread output " + i);
		}
		this.notify();
	}
}