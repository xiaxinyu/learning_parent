package org.learning.dubbo.sayhello;

public class DemoServiceImpl implements DemoService {
	public String sayHello(String name) {
		return "Hello " + name;
	}
}
