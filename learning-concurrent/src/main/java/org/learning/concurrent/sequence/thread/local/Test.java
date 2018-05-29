package org.learning.concurrent.sequence.thread.local;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Consumer(), "consummer" + i).start();
		}
	}
}
