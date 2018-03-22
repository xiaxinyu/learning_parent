package com.learning.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaProducerConfig {
	@Autowired
	private KafkaProducerParameters parameters;

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<String, String>(producerFactory());
	}

	public ProducerFactory<String, String> producerFactory() {
		return new DefaultKafkaProducerFactory<String, String>(producerConfigs());
	}

	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, parameters.getpServers());
		props.put(ProducerConfig.RETRIES_CONFIG, parameters.getRetries());
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, parameters.getBatchSize());
		props.put(ProducerConfig.LINGER_MS_CONFIG, parameters.getLinger());
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, parameters.getBufferMemory());
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}
}