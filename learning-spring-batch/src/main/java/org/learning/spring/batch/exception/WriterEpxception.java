package org.learning.spring.batch.exception;

public class WriterEpxception extends Exception {
	private static final long serialVersionUID = 1L;

	public WriterEpxception(String type, String message) {
		super(type + ":" + message);
	}
}
