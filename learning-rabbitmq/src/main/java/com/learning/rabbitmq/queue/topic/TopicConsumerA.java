package com.learning.rabbitmq.queue.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.A")
public class TopicConsumerA {
	@RabbitHandler
	public void process(String message) {
		System.out.println("Topic ReceiverA  : " + message);
	}
}
