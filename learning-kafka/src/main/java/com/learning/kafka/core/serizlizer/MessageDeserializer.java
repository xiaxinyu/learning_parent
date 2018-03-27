package com.learning.kafka.core.serizlizer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.learning.kafka.beans.Message;
import com.learning.kafka.core.util.BeanUtils;

public class MessageDeserializer implements Deserializer<Message> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public Message deserialize(String topic, byte[] data) {
		return (Message) BeanUtils.convertBytesToObject(data);
	}

	@Override
	public void close() {
	}

}
