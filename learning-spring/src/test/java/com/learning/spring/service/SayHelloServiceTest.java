package com.learning.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class SayHelloServiceTest {

	@Autowired
	private SayHelloService sayHelloService;
	
	@Test
	public void testSayHello(){
		sayHelloService.sayHello("summer");
	}
}
