package org.example.thread.concurrent.timeout;

public class ApplicationException extends Exception {
	private static final long serialVersionUID = 1L;
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(String message, Exception e) {
		super(message, e);
	}
}
