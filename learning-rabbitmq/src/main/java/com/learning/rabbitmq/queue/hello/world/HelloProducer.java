package com.learning.rabbitmq.queue.hello.world;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloProducer {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String message) {
		String context = "hello, " + message + " " + new Date();
		this.rabbitTemplate.convertAndSend("hello", context);
	}
}