package org.learning.rabbitmq.consumer.listener.pojo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.log4j.Logger;
import org.learning.rabbitmq.dto.UserDTO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "pojo-queue")
public class PojoListener {
	private Logger logger = Logger.getLogger(PojoListener.class);

	@RabbitHandler
	public void process(byte[] bytes) {
		logger.info("Receiver message: " + (UserDTO)getObjectFromBytes(bytes) + " from pojo-queue.");
	}

	public Object getObjectFromBytes(byte[] objBytes) {
		Object result = null;
		if (objBytes == null || objBytes.length == 0) {
			return result;
		}

		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			bi = new ByteArrayInputStream(objBytes);
			oi = new ObjectInputStream(bi);
			result = oi.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bi != null) {
					bi.close();
				}
				if (oi != null) {
					oi.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
