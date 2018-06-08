package org.learning.rabbitmq.producer.rabbitmq.queue.helloworld;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWordQueue {
	@Value("${queue.name.helloworld}")
	private String queueName;

	@Bean
	public Queue helloWordQueueMethod() {
		return new Queue(queueName);
	}
}
