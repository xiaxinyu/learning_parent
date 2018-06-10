package org.learning.rabbitmq.producer.controller;

import org.learning.rabbitmq.dto.UserDTO;
import org.learning.rabbitmq.producer.producer.PojoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PojoController {
	@Autowired
	private PojoProducer producer;

	@RequestMapping(value = "/pojo/send", method = RequestMethod.GET)
	public void sendMessage(@RequestParam String id, @RequestParam String name, @RequestParam String phoneNumber) {
		producer.sendMessage(new UserDTO(id, name, phoneNumber));
	}
}
