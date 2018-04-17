package com.learning.rabbitmq.queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class QueueCenter {
	@Bean
	public Queue Queue() {
		return new Queue("hello");
	}
}