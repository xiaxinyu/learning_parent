package com.learning.kafka.core.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import com.learning.kafka.beans.Message;
import com.learning.kafka.core.consumer.ConsumerResource;

@Configuration
@EnableKafka
public class ProducerContext<T> {
	@Autowired
	private ProducerParameters parameters;

	@Autowired
	private ProducerResource producerFactoryContext;

	@Autowired
	private ConsumerResource consumerFactoryContext;

	@Bean
	public KafkaTemplate<String, Message> kafkaTemplate() {
		return new KafkaTemplate<String, Message>(producerFactoryContext.producerFactory());
	}

	@Bean
	public ReplyingKafkaTemplate<String, Message, Message> replyingKafkaTemplate(
			KafkaMessageListenerContainer<String, Message> replyContainer) {
		return new ReplyingKafkaTemplate<String, Message, Message>(producerFactoryContext.producerFactory(),
				replyContainer);
	}

	@Bean
	public KafkaMessageListenerContainer<String, Message> replyContainer() {
		ContainerProperties containerProperties = new ContainerProperties(parameters.getTestTopic());
		return new KafkaMessageListenerContainer<String, Message>(consumerFactoryContext.consumerReplyFactory(),
				containerProperties);
	}
}