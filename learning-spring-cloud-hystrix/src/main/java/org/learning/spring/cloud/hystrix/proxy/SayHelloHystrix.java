package org.learning.spring.cloud.hystrix.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SayHelloHystrix {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="sayHelloHystrix")
	public String sayHello(String name) {
		return restTemplate.getForObject("http://Eureka-Client/sayHello?name=" + name, String.class);
	}
	
	public String sayHelloHystrix(String name) {
		return "hi,"+name+",Sorry,internal error happen in application!";
	}
}