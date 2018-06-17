package org.learning.spring.batch.configuration;

import org.learning.spring.batch.bean.ccb.CCBCreditCSVBean;
import org.learning.spring.batch.bean.ccb.CCBCreditDataLineBean;
import org.learning.spring.batch.listener.CCBCreditItemReaderListener;
import org.learning.spring.batch.listener.CSVJobEexecutionListener;
import org.learning.spring.batch.policy.retry.CSVRetryPolicy;
import org.learning.spring.batch.policy.skip.CSVSkipPolicy;
import org.learning.spring.batch.processor.CCBCreditProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CCBCreditConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ItemStreamReader<CCBCreditCSVBean> ccbCreditCSVReader;
	
	@Autowired
	private ItemStreamWriter<CCBCreditDataLineBean> ccbCreditCSVWriter;

	@Bean
	public Step ccbCreditCSVStep() {
		return stepBuilderFactory.get("ccbCreditCSVStep")
				.<CCBCreditCSVBean, CCBCreditDataLineBean>chunk(10)
				.listener(new CCBCreditItemReaderListener())
				.reader(ccbCreditCSVReader)
				.processor(new CCBCreditProcessor())
				.writer(ccbCreditCSVWriter)
				.faultTolerant()
				.skipPolicy(new CSVSkipPolicy())
				.retryPolicy(new CSVRetryPolicy())
				.listener(new CSVJobEexecutionListener("CCBCredit"))
				.build();
	}

	@Bean
	public Job importCCBCreditCSVJob(Step ccbCreditCSVStep) {
		return jobBuilderFactory
				.get("importCCBCreditCSVJob")
				.flow(ccbCreditCSVStep)
				.end()
				.build();
	}
}
