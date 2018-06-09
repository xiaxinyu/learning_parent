package org.learning.rabbitmq.consumer.rpc.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPCController {
	@Autowired
	private RPCClient client;

	@RequestMapping(value = "/rpc/send", method = RequestMethod.GET)
	public Integer sendMessage() {
		return client.send();
	}
}
