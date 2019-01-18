package org.learning.custom.annotation.base;

import java.lang.reflect.Method;

public class TestThis {
	public static void main(String[] args) throws Exception {
		Method method = Class.forName("org.learning.custom.annotation.base.OneClass").getDeclaredMethod("oneMethod");
		OneAnnotation oneAnnotation = method.getAnnotation(OneAnnotation.class);

		System.out.println(oneAnnotation.parameter1());
		System.out.println(oneAnnotation.parameter2());
	}
}
