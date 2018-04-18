package com.learning.rabbitmq.queue.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.rabbitmq.core.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TopicTest {
	@Autowired
	private TopicProducer sender;

	@Test
	public void topic() throws Exception {
		sender.send();
	}

	@Test
	public void topic1() throws Exception {
		sender.send1();
	}

	@Test
	public void topic2() throws Exception {
		sender.send2();
	}
}
