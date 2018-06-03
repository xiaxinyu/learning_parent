package org.learning.spring.cloud.hystrix.dashboard.controller;

import org.learning.spring.cloud.hystrix.dashboard.register.HelloServiceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private HelloServiceRegister helloService;
	
	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		return helloService.sayHelloService(name);
	}
}
