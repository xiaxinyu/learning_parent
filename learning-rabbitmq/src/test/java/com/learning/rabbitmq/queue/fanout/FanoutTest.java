package com.learning.rabbitmq.queue.fanout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.rabbitmq.core.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FanoutTest {
	@Autowired
	private FanoutProducer fanoutSender;

	@Test
	public void setFanoutSender() {
		fanoutSender.send();
	}
}
