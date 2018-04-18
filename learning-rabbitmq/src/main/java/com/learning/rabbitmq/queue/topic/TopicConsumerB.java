package com.learning.rabbitmq.queue.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.B")
public class TopicConsumerB {
	@RabbitHandler
	public void process(String message) {
		System.out.println("Topic ReceiverB  : " + message);
	}
}