package com.learning.spring.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SayHelloService {
	private Logger logger = Logger.getLogger(SayHelloService.class);

	public void sayHello(String name) {
		logger.info("Hello," + name);
	}
}
