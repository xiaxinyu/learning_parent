package org.learning.rabbitmq.producer.rpc.server;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RPCQueue {
	@Value("${rpc-mode.queue.name.rpc}")
	private String queueName;
	
	@Bean
	public Queue queueRPC() {
		return new Queue(queueName);
	}
}
