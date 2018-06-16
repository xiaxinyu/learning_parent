package org.learning.spring.batch.exception;

import org.springframework.batch.item.ParseException;

public class CSVParseException extends ParseException {
	private static final long serialVersionUID = 1L;
	private String input;

	private int lineNumber;

	public CSVParseException(String channel, String message, String input) {
		super(channel + ":" + message);
		this.input = input;
	}

	public CSVParseException(String channel, String message) {
		super(channel + ":" + message);
	}

	public CSVParseException(String message, String input, int lineNumber) {
		super(message);
		this.input = input;
		this.lineNumber = lineNumber;
	}

	public CSVParseException(String message, Throwable cause, String input, int lineNumber) {
		super(message, cause);
		this.input = input;
		this.lineNumber = lineNumber;
	}

	public String getInput() {
		return input;
	}

	public int getLineNumber() {
		return lineNumber;
	}

}
