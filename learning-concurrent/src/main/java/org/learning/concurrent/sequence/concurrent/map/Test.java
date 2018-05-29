package org.learning.concurrent.sequence.concurrent.map;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new Consumer("winner"), "consummer" + i).start();
		}
		
		for (int i = 0; i < 100; i++) {
			new Thread(new Consumer("summer"), "consummer" + i).start();
		}
	}
}
