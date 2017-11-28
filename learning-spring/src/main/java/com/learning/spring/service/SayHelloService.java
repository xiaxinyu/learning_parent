package com.learning.spring.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring.repository.SayHelloDao;

@Service
public class SayHelloService {
	private Logger logger = Logger.getLogger(SayHelloService.class);

	@Autowired
	private SayHelloDao sayHelloDao;
	
	public void sayHello(String name) {
		logger.info("say Hello from service");
		sayHelloDao.sayHello(name);
	}
}
