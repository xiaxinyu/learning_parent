package com.learning.rabbitmq.queue.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class FanoutConsumerC {
	@RabbitHandler
	public void process(String message) {
		System.out.println("fanout Receiver C: " + message);
	}
}
