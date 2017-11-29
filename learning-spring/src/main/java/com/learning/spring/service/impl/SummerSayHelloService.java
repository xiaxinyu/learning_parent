package com.learning.spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.learning.spring.service.ISayHelloService;

@Service(value="summerSayHelloService")
public class SummerSayHelloService implements ISayHelloService{
	private Logger logger = Logger.getLogger(SummerSayHelloService.class);
	
	public void sayHello(String name) {
		logger.info("Summer say hello to " + name);
	}
}
