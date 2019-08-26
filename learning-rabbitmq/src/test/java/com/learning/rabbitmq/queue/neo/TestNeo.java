package com.learning.rabbitmq.queue.neo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.rabbitmq.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestNeo {
	@Autowired
	private NeoProducer sender;

	@org.junit.Test
	public void neo() throws Exception {
		for (int i = 0; i < 100; i++) {
			sender.send("message" + i);
		}
	}
}
