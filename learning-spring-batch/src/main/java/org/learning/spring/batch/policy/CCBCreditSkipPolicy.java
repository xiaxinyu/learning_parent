package org.learning.spring.batch.policy;

import org.learning.spring.batch.exception.CCBCreditParseException;
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;

public class CCBCreditSkipPolicy extends AlwaysSkipItemSkipPolicy {
	@Override
	public boolean shouldSkip(java.lang.Throwable t, int skipCount) {
		if (t instanceof FlatFileParseException || t instanceof CCBCreditParseException ) {
			return true;
		}
		return false;
	}
}