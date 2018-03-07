package org.learning.dubbo.sayhello;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "sayhello\\dubbo-sayhello-consumer.xml" });
		context.start();
		// obtain proxy object for remote invocation
		DemoService demoService = (DemoService) context.getBean("demoService");
		// execute remote invocation
		String hello = demoService.sayHello("world");
		// show the result
		System.out.println(hello);
	}

}
