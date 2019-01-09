package org.learning.spring.cloud.ribbon.controller;

import org.learning.spring.cloud.ribbon.proxy.SayHelloProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private SayHelloProxy proxy;
	
	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		return proxy.sayHello(name);
	}
}