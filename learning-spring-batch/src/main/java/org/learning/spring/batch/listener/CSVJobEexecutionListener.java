package org.learning.spring.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

public class CSVJobEexecutionListener extends StepExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(CSVJobEexecutionListener.class);

	private String type;

	public CSVJobEexecutionListener(String type) {
		this.type = type;
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		log.info(type + " JOB FINISHED!");
		return ExitStatus.COMPLETED;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info(type + " JOB STARTED!");
	}
}
