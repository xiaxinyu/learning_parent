package org.learning.spring.batch.policy.skip;

import org.learning.spring.batch.exception.CSVParseException;
import org.learning.spring.batch.exception.ProcessorEpxception;
import org.learning.spring.batch.exception.WriterEpxception;
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.transform.IncorrectTokenCountException;

public class CSVSkipPolicy extends AlwaysSkipItemSkipPolicy {
	@Override
	public boolean shouldSkip(java.lang.Throwable t, int skipCount) {
		if (t instanceof FlatFileParseException || t instanceof CSVParseException
				|| t instanceof IncorrectTokenCountException || t instanceof ProcessorEpxception
				|| t instanceof WriterEpxception) {
			return true;
		}
		return false;
	}
}