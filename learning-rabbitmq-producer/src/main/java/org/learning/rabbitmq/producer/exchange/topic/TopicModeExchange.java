package org.learning.rabbitmq.producer.exchange.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicModeExchange {
	@Value("${topic-mode.exchange.name}")
	public String exchangeName;

	@Value("${topic-mode.routing-key.info}")
	private String routingKeyInfo;

	@Value("${topic-mode.routing-key.warn}")
	private String routingKeyWarn;

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(exchangeName);
	}

	@Bean
	public Binding bindingExchangeWithTopicQueueA(Queue queueInfo, TopicExchange topicExchange) {
		return BindingBuilder.bind(queueInfo).to(topicExchange).with(this.routingKeyInfo);
	}

	@Bean
	public Binding bindingExchangeWithTopicQueueB(Queue queueWarn, TopicExchange topicExchange) {
		return BindingBuilder.bind(queueWarn).to(topicExchange).with(this.routingKeyWarn);
	}
}
