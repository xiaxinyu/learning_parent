package org.learning.spring.batch.exception;

public class ProcessorEpxception extends Exception {
	private static final long serialVersionUID = 1L;

	public ProcessorEpxception(String type, String message) {
		super(type + ":" + message);
	}
}
