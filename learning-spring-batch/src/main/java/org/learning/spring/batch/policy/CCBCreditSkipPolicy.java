package org.learning.spring.batch.policy;

import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;

public class CCBCreditSkipPolicy extends AlwaysSkipItemSkipPolicy {
	@Override
	public boolean shouldSkip(java.lang.Throwable t, int skipCount) {
		if (t instanceof FlatFileParseException) {
			return true;
		}
		return false;
	}
}