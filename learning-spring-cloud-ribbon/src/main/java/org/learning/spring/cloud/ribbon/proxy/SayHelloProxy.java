package org.learning.spring.cloud.ribbon.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SayHelloProxy {
	@Autowired
	private RestTemplate restTemplate;

	public String sayHello(String name) {
		return restTemplate.getForObject("http://Eureka-Client/sayHello?name=" + name, String.class);
	}
}