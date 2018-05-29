package org.learning.concurrent.sequence.syn.lock;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Consumer(), "consummer" + i).start();
		}
	}
}
