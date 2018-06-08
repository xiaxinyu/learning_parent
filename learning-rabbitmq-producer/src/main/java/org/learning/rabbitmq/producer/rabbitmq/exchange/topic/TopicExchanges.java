package org.learning.rabbitmq.producer.rabbitmq.exchange.topic;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchanges {
	private Logger logger = Logger.getLogger(TopicExchanges.class);

	@Value("${exchange.name.topic}")
	public String exchangeName;

	@Bean
	public TopicExchange topicFanoutExchange() {
		return new TopicExchange(exchangeName);
	}

	@Bean
	public Binding bindingExchangeWithTopicQueueA(Queue topicQueueA, TopicExchange topicFanoutExchange) {
		logger.info("binding exchange: " + topicFanoutExchange.getName() + " queue: " + topicQueueA.getName());
		return BindingBuilder.bind(topicQueueA).to(topicFanoutExchange).with("topic.main");
	}

	@Bean
	public Binding bindingExchangeWithTopicQueueB(Queue topicQueueB, TopicExchange topicFanoutExchange) {
		logger.info("binding exchange: " + topicFanoutExchange.getName() + " queue: " + topicQueueB.getName());
		return BindingBuilder.bind(topicQueueB).to(topicFanoutExchange).with("topic.others");
	}
}
