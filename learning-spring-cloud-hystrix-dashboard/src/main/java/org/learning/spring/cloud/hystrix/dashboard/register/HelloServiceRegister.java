package org.learning.spring.cloud.hystrix.dashboard.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloServiceRegister {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="sayHelloServiceError")
	public String sayHelloService(String name) {
		return restTemplate.getForObject("http://sayHello/sayHello?name=" + name, String.class);
	}
	
	public String sayHelloServiceError(String name) {
		return "hi,"+name+",Sorry,internal error happen in application!";
	}
}
