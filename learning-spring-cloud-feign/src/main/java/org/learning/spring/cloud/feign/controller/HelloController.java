package org.learning.spring.cloud.feign.controller;

import org.learning.spring.cloud.feign.register.SayHelloRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	SayHelloRegister sayHelloRegister;

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		return sayHelloRegister.sayHello(name);
	}
}
