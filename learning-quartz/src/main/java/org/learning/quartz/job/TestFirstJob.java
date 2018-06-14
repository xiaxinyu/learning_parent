package org.learning.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestFirstJob implements Job {
	private static Logger logger = LoggerFactory.getLogger(TestFirstJob.class);

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("I am summer.");
	}

}
