package org.learning.spring.cloud.hystrix.proxy;

import org.springframework.stereotype.Component;

@Component
public class SayHelloHystrixFallback implements SayHelloHystrix {
	@Override
	public String sayHello(String name) {
		return "hi," + name + ",Sorry,internal error happen in application!";
	}
}