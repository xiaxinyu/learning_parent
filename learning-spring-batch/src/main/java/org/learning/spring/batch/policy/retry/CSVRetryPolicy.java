package org.learning.spring.batch.policy.retry;

import org.learning.spring.batch.exception.CSVParseException;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.AlwaysRetryPolicy;

public class CSVRetryPolicy extends AlwaysRetryPolicy {
	private static final long serialVersionUID = 1L;
	private static final int RETRY_MAX = 3;

	@Override
	public boolean canRetry(RetryContext context) {
		Throwable throwable = context.getLastThrowable();
		if (throwable instanceof FlatFileParseException || throwable instanceof CSVParseException) {
			int retryCount = context.getRetryCount();
			if (retryCount >= RETRY_MAX) {
				return false;
			}
			return true;
		}
		return false;
	}
}
