package com.learning.kafka.core.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.learning.kafka.beans.Message;
import com.learning.kafka.core.serizlizer.MessageSerializer;

@Configuration
@EnableKafka
public class KafkaProducerConfig<T> {
	@Autowired
	private KafkaProducerParameters parameters;

	@Bean
	public KafkaTemplate<String, Message> kafkaTemplate() {
		return new KafkaTemplate<String, Message>(producerFactory());
	}

	public ProducerFactory<String, Message> producerFactory() {
		return new DefaultKafkaProducerFactory<String, Message>(producerConfigs());
	}

	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, parameters.getpServers());
		props.put(ProducerConfig.RETRIES_CONFIG, parameters.getRetries());
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, parameters.getBatchSize());
		props.put(ProducerConfig.LINGER_MS_CONFIG, parameters.getLinger());
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, parameters.getBufferMemory());
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, MessageSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MessageSerializer.class);
		return props;
	}
}