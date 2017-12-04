package com.learning.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.spring.service.impl.GiveNameServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class SayHelloServiceTest {

	@Autowired
	private ISayHelloService summerSayHelloService;
	
	@Autowired
	private ISayHelloService winnerSayHelloService;
	
	@Autowired                        
	private IGiveNameService nameService;
	
	@Test
	public void testSayHello(){
		summerSayHelloService.sayHello("summer");
		winnerSayHelloService.sayHello("winner");
	}
	
	@Test
	public void testGiveName(){
		nameService.giveName("spring");
	}
}
