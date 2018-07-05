package org.learning.thread.tradition.wait;

public class Condition {
	public void lock() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void unLock() {
		this.notify();
	}
}
