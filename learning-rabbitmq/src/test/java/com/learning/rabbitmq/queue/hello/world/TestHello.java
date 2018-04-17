package com.learning.rabbitmq.queue.hello.world;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.rabbitmq.core.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestHello {
	@Autowired
	private HelloProducer sender;

	@org.junit.Test
	public void hello() throws Exception {
		sender.send("summer");
	}
}
