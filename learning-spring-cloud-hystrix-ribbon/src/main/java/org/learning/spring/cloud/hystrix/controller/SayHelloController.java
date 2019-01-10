package org.learning.spring.cloud.hystrix.controller;

import org.learning.spring.cloud.hystrix.proxy.SayHelloHystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
	private Logger logger = LoggerFactory.getLogger(SayHelloController.class);
	
	@Autowired
	private SayHelloHystrix hystrix;

	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		logger.info("Hystrix-Ribbon-sayHello, request parameter[name={}]", name);
		return hystrix.sayHello(name);
	}
}