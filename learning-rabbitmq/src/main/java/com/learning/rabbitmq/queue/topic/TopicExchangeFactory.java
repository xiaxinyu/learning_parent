package com.learning.rabbitmq.queue.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeFactory {
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange("topicExchange");
	}

	/**
	 * 绑定队列到交换机上,路由模式，需要完整匹配topic.message，才能接受
	 * 
	 * @param queueMessage
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}

	/**
	 * topic模式，前缀匹配到topic.即可接受
	 * 
	 * @param queueMessages
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}
}
