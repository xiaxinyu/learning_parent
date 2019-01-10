package org.learning.spring.cloud.hystrix.controller;

import org.learning.spring.cloud.hystrix.proxy.SayHelloHystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
	@Autowired
	private SayHelloHystrix hystrix;

	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		return hystrix.sayHello(name);
	}
}