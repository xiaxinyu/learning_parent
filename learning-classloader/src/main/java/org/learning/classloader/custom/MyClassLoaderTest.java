package org.learning.classloader.custom;

public class MyClassLoaderTest {
	public static void main(String[] args) {
		MyClassLoader cl1 = new MyClassLoader();
		try {
			Class c1 = cl1.loadClass("Hello");
			Object hello = c1.newInstance();
			System.out.println(hello);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("main-ClassNotFoundException");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
