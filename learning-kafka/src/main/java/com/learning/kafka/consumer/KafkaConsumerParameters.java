package com.learning.kafka.consumer;

import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerParameters {
	public String cServers = "192.168.179.131:9092";
	public boolean enableAutoCommit = true;
	public String sessionTimeout = "6000";
	public String autoCommitInterval = "100";
	public String groupId = "test-consumer-group";
	public String autoOffsetReset="latest";
	public int concurrency= 10;
	public String testTopic = "test";

	public String getcServers() {
		return cServers;
	}

	public void setcServers(String cServers) {
		this.cServers = cServers;
	}

	public boolean getEnableAutoCommit() {
		return enableAutoCommit;
	}

	public void setEnableAutoCommit(boolean enableAutoCommit) {
		this.enableAutoCommit = enableAutoCommit;
	}

	public String getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(String sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public String getAutoCommitInterval() {
		return autoCommitInterval;
	}

	public void setAutoCommitInterval(String autoCommitInterval) {
		this.autoCommitInterval = autoCommitInterval;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getAutoOffsetReset() {
		return autoOffsetReset;
	}

	public void setAutoOffsetReset(String autoOffsetReset) {
		this.autoOffsetReset = autoOffsetReset;
	}

	public int getConcurrency() {
		return concurrency;
	}

	public void setConcurrency(int concurrency) {
		this.concurrency = concurrency;
	}

	public String getTestTopic() {
		return testTopic;
	}

	public void setTestTopic(String testTopic) {
		this.testTopic = testTopic;
	}

}
