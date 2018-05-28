package org.learning.lock.clazz;

public class ClazzLock {
	public void printCounter(String name) {
		synchronized (ClazzLock.class) {
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " : Current counter is " + i);
			}
		}
	}
}
