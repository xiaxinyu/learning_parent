package org.learning.spring.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class CCBCreditJobEexecutionListener extends JobExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(CCBCreditJobEexecutionListener.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("CCBCredit JOB STARTED!");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("CCBCredit JOB FINISHED!");
	}
}
