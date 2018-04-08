package com.learning.kafka.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.kafka.beans.Message;
import com.learning.kafka.beans.Result;
import com.learning.kafka.producer.MessageProducer;
import com.learning.kafka.producer.ReplyMessageProducer;

@Controller
public class SendMessageController {

	@Autowired
	private MessageProducer producer;

	@Autowired
	private ReplyMessageProducer replyProducer;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public Result sendMessage(@RequestParam(value = "message", required = true) String message) {
		producer.sendMessage(new Message(UUID.randomUUID().toString(), message));
		return new Result(Result.ResultStatus.SUCCESS, "It's ok.");
	}

	@RequestMapping(value = "/sendReplyMessage", method = RequestMethod.POST)
	@ResponseBody
	public Result sendReplyMessage(@RequestParam(value = "message", required = true) String message) {
		replyProducer.sendMessage(new Message(UUID.randomUUID().toString(), message));
		return new Result(Result.ResultStatus.SUCCESS, "It's ok.");
	}
}
