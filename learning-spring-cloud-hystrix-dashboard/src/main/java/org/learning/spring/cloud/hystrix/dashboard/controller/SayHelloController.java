package org.learning.spring.cloud.hystrix.dashboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
	private Logger logger = LoggerFactory.getLogger(SayHelloController.class);

	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		logger.info("Hystrix-Dashboard-sayHello, request parameter[name={}]", name);
		return "Hello," + name + ",I am from Hystrix-Dashboard";
	}
}