package com.learning.kafka.core.serizlizer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.learning.kafka.beans.Message;
import com.learning.kafka.core.util.BeanUtils;

public class MessageSerializer implements Serializer<Message> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(String topic, Message data) {
		return BeanUtils.convertObjectToBytes(data);
	}

	@Override
	public void close() {
	}

}
