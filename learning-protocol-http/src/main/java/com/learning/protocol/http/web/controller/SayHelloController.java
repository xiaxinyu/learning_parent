package com.learning.protocol.http.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
	private Logger logger = LoggerFactory.getLogger(SayHelloController.class);

	@RequestMapping(method = RequestMethod.GET, path = "sayHello")
	public String index(@RequestParam String name) {
		logger.info("request parameter:" + name);
		return "Hello," + name;
	}
}
