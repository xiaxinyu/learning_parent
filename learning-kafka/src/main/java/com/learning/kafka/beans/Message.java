package com.learning.kafka.beans;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String content;

	public Message(String name, String content) {
		this.name = name;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [name=" + name + ", content=" + content + "]";
	}
}
