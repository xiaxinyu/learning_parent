package com.learning.kafka.producer;

import org.springframework.stereotype.Component;

@Component
public class KafkaProducerParameters {
	public String pServers = "192.168.179.131:9092";
	public int retries=1;
	public int batchSize=4096;
	public int linger=1;
	public int bufferMemory=40960;
	public String testTopic="test";

	public String getpServers() {
		return pServers;
	}

	public void setpServers(String pServers) {
		this.pServers = pServers;
	}

	public int getRetries() {
		return retries;
	}

	public void setRetries(int retries) {
		this.retries = retries;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public int getLinger() {
		return linger;
	}

	public void setLinger(int linger) {
		this.linger = linger;
	}

	public int getBufferMemory() {
		return bufferMemory;
	}

	public void setBufferMemory(int bufferMemory) {
		this.bufferMemory = bufferMemory;
	}

	public String getTestTopic() {
		return testTopic;
	}

	public void setTestTopic(String testTopic) {
		this.testTopic = testTopic;
	}
}
