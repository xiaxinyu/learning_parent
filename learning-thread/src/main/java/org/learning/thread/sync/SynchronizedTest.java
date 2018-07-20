package org.learning.thread.sync;

public class SynchronizedTest {
	public static void main(String[] args) {
		final Output out = new Output();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.print("summer");
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.print("winner");
				}
			}
		}).start();
	}
}

class Output {
	public void print(String value) {
		// synchronized(value) { this is a wrong way to synchronize, beacause value's
		// address changes
		// every time when others invoke
		synchronized (this) {
			if (value != null && value.length() > 0) {
				for (int i = 0; i < value.length(); i++) {
					System.out.print(value.charAt(i));
					if (i == (value.length() - 1)) {
						System.out.println();
					}
				}
			}
		}
	}
}