package org.learning.spring.ioc.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		User user = context.getBean(User.class);
		System.out.println(user.toString());
	}
}
