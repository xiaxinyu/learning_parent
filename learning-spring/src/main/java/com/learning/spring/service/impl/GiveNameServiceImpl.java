package com.learning.spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring.repository.SayHelloDao;
import com.learning.spring.service.IGiveNameService;

/**
 * @author summer.xiasz
 */
@Service
public class GiveNameServiceImpl implements IGiveNameService {
	private Logger logger = Logger.getLogger(GiveNameServiceImpl.class);

	@Override
	public void giveName(String name) {
		logger.info("My give name is " + name);
	}
}
