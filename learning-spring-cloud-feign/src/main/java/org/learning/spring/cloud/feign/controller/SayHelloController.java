package org.learning.spring.cloud.feign.controller;

import org.learning.spring.cloud.feign.proxy.SayHelloProxy;
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
	SayHelloProxy proxy;

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		logger.info("Feign-SayHelloController, request parameter[name={}]", name);
		return proxy.sayHello(name);
	}
}