package org.learning.spring.aop.test;

import org.learning.spring.aop.plain.BraveKnight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		BraveKnight knight = context.getBean(BraveKnight.class);
		knight.saying();
		System.out.println(knight.toString());
		//AopNamespaceHandler
		//AbstractAutoProxyCreator
	}
}
