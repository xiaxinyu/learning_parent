package org.learning.spring.ioc.multicaster;

public class Test {
	public static void main(String[] args) {
		AppMulticasterPublisher t = new AppMulticasterPublisher();
		t.publishEvent();
	}
}
