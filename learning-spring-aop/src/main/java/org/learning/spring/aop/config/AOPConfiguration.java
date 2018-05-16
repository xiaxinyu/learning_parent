package org.learning.spring.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPConfiguration {
	@Before("execution(* org.learning.spring.aop.plain..*.*(..)) ")
	public void beforeExecute(JoinPoint jp) {
		System.out.println("注解类型前置通知" + jp.getTarget().getClass().getName());
	}

	@After("execution(* org.learning.spring.aop.plain..*.*(..)) ")
	public void afterExecute(JoinPoint jp) {
		System.out.println("注解类型后置通知" + jp.getTarget().getClass().getName());
	}

	@Around("execution(* org.learning.spring.aop.plain..*.*(..)) ")
	public void aroundExecute(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("注解类型环绕通知..环绕前");
		pjp.proceed();// 执行方法
		System.out.println("注解类型环绕通知..环绕后");
	}
}
