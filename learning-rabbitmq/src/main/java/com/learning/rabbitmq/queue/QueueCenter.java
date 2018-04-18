package com.learning.rabbitmq.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueCenter {
	/**
	 * point to point
	 * @return
	 */
	@Bean
	public Queue QueueHello() {
		return new Queue("hello");
	}
	
	/**
	 * competitor
	 * @return
	 */
	@Bean
	public Queue QueueNeo() {
		return new Queue("neo");
	}

	/**
	 * fanout queue
	 * @return
	 */
	@Bean
	public Queue AMessage() {
		return new Queue("fanout.A");
	}

	@Bean
	public Queue BMessage() {
		return new Queue("fanout.B");
	}

	@Bean
	public Queue CMessage() {
		return new Queue("fanout.C");
	}

	/**
	 * topic queue
	 * @return
	 */
	@Bean
	public Queue queueMessage() {
		return new Queue("topic.A");
	}

	@Bean
	public Queue queueMessages() {
		return new Queue("topic.B");
	}
}