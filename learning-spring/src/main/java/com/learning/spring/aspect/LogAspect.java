package com.learning.spring.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	private Logger logger = Logger.getLogger(LogAspect.class);
	
	@Before("execution(* com.learning.spring.service.*.*(..))")
	public void doAcessCheck(){
		logger.info("before accessing!");
	}
}
