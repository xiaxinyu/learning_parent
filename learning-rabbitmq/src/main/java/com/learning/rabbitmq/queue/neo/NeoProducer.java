package com.learning.rabbitmq.queue.neo;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeoProducer {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String message) {
		String context = "hello, " + message + " " + new Date();
		this.rabbitTemplate.convertAndSend("neo", context);
	}
}
