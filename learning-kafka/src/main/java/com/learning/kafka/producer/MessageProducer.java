package com.learning.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.learning.kafka.beans.Message;
import com.learning.kafka.core.producer.KafkaProducerParameters;

@Component
public class MessageProducer {
	private Logger logger = Logger.getLogger(MessageProducer.class);
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	@Autowired
	private KafkaProducerParameters parameters;

	public void sendMessage(final Message message) {
		logger.info("Start to message：Message Id = " + message.getName());
		ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send(parameters.getTestTopic(), message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {
			@Override
			public void onSuccess(SendResult<String, Message> result) {
				ProducerRecord<String, Message> record = result.getProducerRecord();
				logger.info("Successfully send.Message Id = " + message.getName() + ",Topic=" + record.topic()
						+ ",Partition=" + record.partition());
			}

			@Override
			public void onFailure(Throwable arg0) {
				logger.error(arg0.getMessage());
			}
		});
	}
}
