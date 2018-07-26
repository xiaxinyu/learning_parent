package org.learning.concurrent.concurrent.map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HashMapTest {
	public static void main(String[] args) throws InterruptedException {
		final HashMap<String, String> map = new HashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 500000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "ftf" + i).start();
				}
			}
		}, "ftf");
		t.start();
		t.join();
		
		Thread.sleep(60000);
	}
}
