package org.learning.classloader.detection;

public class SystemDetection {
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
	}
}
