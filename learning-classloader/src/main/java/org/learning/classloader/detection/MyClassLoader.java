package org.learning.classloader.detection;

public class MyClassLoader {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(ClassLoaderTest.class.getClassLoader());
		System.out.println(System.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
	}
}

class ClassLoaderTest {
}
