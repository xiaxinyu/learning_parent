package org.learning.thread.concurrent.lock.condition;

public class ConditionTest {
	private static BoundedBuffer buffer = new BoundedBuffer();

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				public void run() {
					int counter = 0;
					while (true) {
						String name = Thread.currentThread().getName() + (++counter);
						try {
							Thread.sleep(400);
							buffer.put(name);
							System.out.println("Put:" + name);
						} catch (InterruptedException e) {

						}
					}
				}
			}).start();

			new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(500);
							Object value = buffer.take();
							System.out.println("Take:" + value.toString());
						} catch (InterruptedException e) {

						}
					}
				}
			}).start();
		}
	}
}
