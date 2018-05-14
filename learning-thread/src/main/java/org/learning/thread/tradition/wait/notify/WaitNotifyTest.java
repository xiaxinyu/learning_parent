package org.learning.thread.tradition.wait.notify;

public class WaitNotifyTest {
	public static void main(String[] args) {
		Output op = new Output();
		Thread s1 = new Thread(new Runnable() {
			public void run() {
				op.printInSubThread1();
			}
		});
		s1.setPriority(9);
		s1.start();
		
		Thread s2 = new Thread(new Runnable() {
			public void run() {
				op.printInSubThread2();
			}
		});
		s2.setPriority(5);
		s2.start();


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
		this.notifyAll();
	}

	public synchronized void printInSubThread1() {
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
			System.out.println("SubThread output1 " + i);
		}
	}
	
	public synchronized void printInSubThread2() {
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
			System.out.println("SubThread output2 " + i);
		}
	}
}