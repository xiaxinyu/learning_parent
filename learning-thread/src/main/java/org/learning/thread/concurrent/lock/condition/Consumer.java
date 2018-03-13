package org.learning.thread.concurrent.lock.condition;

public class Consumer implements Runnable {
	private BoundedBuffer buffer;

	public Consumer(BoundedBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				System.out.println("Consume:" + buffer.take().toString());
			} catch (InterruptedException e) {

			}
		}
	}
}
