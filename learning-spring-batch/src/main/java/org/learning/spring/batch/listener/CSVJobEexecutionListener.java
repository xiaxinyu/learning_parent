package org.learning.spring.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class CSVJobEexecutionListener extends JobExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(CSVJobEexecutionListener.class);

	private String type;

	public CSVJobEexecutionListener(String type) {
		this.type = type;
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info(type + " JOB STARTED!");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info(type + " JOB FINISHED!");
	}
}
