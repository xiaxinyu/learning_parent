package com.learning.kafka.producer;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.learning.kafka.beans.Message;
import com.learning.kafka.core.producer.ProducerParameters;

@Component
public class ReplyMessageProducer {
	private Logger logger = Logger.getLogger(ReplyMessageProducer.class);
	@Autowired
	private ReplyingKafkaTemplate<String, Message, Message> kafkaTemplate;

	@Autowired
	private ProducerParameters parameters;

	public void sendMessage(final Message message) {
		ProducerRecord<String, Message> record = new ProducerRecord<String, Message>(parameters.getTestTopic(),	message);
		RequestReplyFuture<String, Message, Message> replyFuture = kafkaTemplate.sendAndReceive(record);

		try {
			SendResult<String, Message> sendResult = replyFuture.getSendFuture().get();
			logger.info("Start to message:Message = " + sendResult.getRecordMetadata());
			ConsumerRecord<String, Message> consumerRecord = replyFuture.get();
			logger.info("Return value: " + consumerRecord.value());
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e);
		}
	}
}
