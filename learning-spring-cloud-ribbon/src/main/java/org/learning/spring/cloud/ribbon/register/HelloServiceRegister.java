package org.learning.spring.cloud.ribbon.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceRegister {
	@Autowired
	private RestTemplate restTemplate;

	public String hiService(String name) {
		return restTemplate.getForObject("http://sayHello/sayHello?name=" + name, String.class);
	}
}
