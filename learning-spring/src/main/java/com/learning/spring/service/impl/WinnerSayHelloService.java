package com.learning.spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.learning.spring.service.ISayHelloService;

@Service(value="winnerSayHelloService")
public class WinnerSayHelloService implements ISayHelloService{
	private Logger logger = Logger.getLogger(WinnerSayHelloService.class);
	
	public void sayHello(String name) {
		logger.info("Winner say hello to " + name);
	}
}
