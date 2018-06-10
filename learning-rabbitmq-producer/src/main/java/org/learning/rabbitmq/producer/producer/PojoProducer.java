package org.learning.rabbitmq.producer.producer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.log4j.Logger;
import org.learning.rabbitmq.dto.UserDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PojoProducer {
	private Logger logger = Logger.getLogger(PojoProducer.class);

	@Autowired
	private RabbitTemplate template;

	@Value("${pojo-mode.queue.name}")
	private String queueName;

	public void sendMessage(UserDTO user) {
		logger.info("Send message: " + user + " to " + this.queueName);
		template.convertAndSend(queueName, getBytesFromObject(user));
	}

	private byte[] getBytesFromObject(Serializable obj) {
		byte[] result = null;
		if (obj == null) {
			return result;
		}

		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			result = bo.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bo != null) {
					bo.close();
				}
				if (oo != null) {
					oo.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
