package org.rpc.client;

import org.rpc.api.SaHelloService;

public class Test {
	public static void main(String[] args) {
		SaHelloService helloService = ProxyFactory.getInstance(SaHelloService.class);
		System.out.println("say:" + helloService.sayHello("张三"));
		System.out.println("Person:" + helloService.getPerson("张三"));
	}
}
