package com.learning.kafka.core.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import com.learning.kafka.beans.Message;
import com.learning.kafka.core.serizlizer.MessageDeserializer;

@Component
public class ConsumerResource {

	@Autowired
	private ConsumerParameters parameters;

	public ConsumerFactory<String, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<String, String>(consumerConfigs());
	}
	
	public ConsumerFactory<String, Message> consumerReplyFactory() {
		return new DefaultKafkaConsumerFactory<String, Message>(consumerConfigs());
	}

	public Map<String, Object> consumerConfigs() {
		Map<String, Object> propsMap = new HashMap<String, Object>(8);
		propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, parameters.getcServers());
		propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, parameters.getEnableAutoCommit());
		propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, parameters.getAutoCommitInterval());
		propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, parameters.getSessionTimeout());
		propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, MessageDeserializer.class);
		propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MessageDeserializer.class);
		propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, parameters.getGroupId());
		propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, parameters.getAutoOffsetReset());
		return propsMap;
	}
}
