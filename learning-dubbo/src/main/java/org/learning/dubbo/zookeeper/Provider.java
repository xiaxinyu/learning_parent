package org.learning.dubbo.zookeeper;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "zookeeper\\dubbo-sayhello-provider.xml" });
		context.start();
		// press any key to exit
		System.in.read();
	}

}
