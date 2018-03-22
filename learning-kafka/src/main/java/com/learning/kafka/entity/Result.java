package com.learning.kafka.entity;

public class Result {
	private ResultStatus status;
	private String message;

	public Result(ResultStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResultStatus getStatus() {
		return status;
	}

	public void setStatus(ResultStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static enum ResultStatus {
		SUCCESS, FAIL
	}
}
