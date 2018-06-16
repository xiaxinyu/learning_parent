package org.learning.spring.batch.exception;

import org.springframework.batch.item.ParseException;

public class CCBCreditParseException extends ParseException {
	private static final long serialVersionUID = 1L;
	private String input;

	private int lineNumber;

	public CCBCreditParseException(String message) {
		super(message);
	}

	public CCBCreditParseException(String message, String input) {
		super(message);
		this.input = input;
	}

	public CCBCreditParseException(String message, String input, int lineNumber) {
		super(message);
		this.input = input;
		this.lineNumber = lineNumber;
	}

	public CCBCreditParseException(String message, Throwable cause, String input, int lineNumber) {
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
