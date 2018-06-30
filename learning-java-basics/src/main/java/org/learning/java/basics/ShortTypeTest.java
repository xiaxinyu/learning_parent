package org.learning.java.basics;

public class ShortTypeTest {
	public static void main(String[] args) {
		short s1 = 1;
		System.out.println(getType(s1));
		s1 += 1;
		System.out.println(getType(s1));
		System.out.println(s1);
	}

	public static String getType(Object o) {
		return o.getClass().toString();
	}
}
