package org.learning.thread.concurrent.lock.condition;

public class Producer implements Runnable {
	private BoundedBuffer buffer;

	public Producer(BoundedBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(400);
				String prduction =  "Shoes";
				buffer.put(prduction);
				System.out.println("Produce:" + prduction);
			} catch (InterruptedException e) {

			}
		}
	}

}
