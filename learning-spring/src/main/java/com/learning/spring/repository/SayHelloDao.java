package com.learning.spring.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class SayHelloDao {
	private Logger logger = Logger.getLogger(SayHelloDao.class);

	public void sayHello(String name) {
		logger.info("Hello," + name);
	}
}
