package org.learning.spring.batch.configuration;

import org.learning.spring.batch.bean.CCBCreditCSVBean;
import org.learning.spring.batch.bean.DataLineBean;
import org.learning.spring.batch.listener.CCBCreditItemReaderListener;
import org.learning.spring.batch.policy.CCBCreditSkipPolicy;
import org.learning.spring.batch.processor.CCBCreditProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class CCBCreditConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ItemStreamReader<CCBCreditCSVBean> ccbCreditCSVReader;
	
	@Autowired
	private ItemStreamWriter<DataLineBean> ccbCreditCSVWriter;

	@Bean
	public Step ccbCreditCSVStep() {
		return stepBuilderFactory.get("ccbCreditCSVStep")
				.<CCBCreditCSVBean, DataLineBean>chunk(10)
				.listener(new CCBCreditItemReaderListener())
				.reader(ccbCreditCSVReader)
				.processor(new CCBCreditProcessor())
				.writer(ccbCreditCSVWriter)
				.faultTolerant()
				.skipPolicy(new CCBCreditSkipPolicy())
				.build();
	}

	@Bean
	public Job importUserJob(Step ccbCreditCSVStep) {
		return jobBuilderFactory
				.get("importUserJob")
				.flow(ccbCreditCSVStep)
				.end()
				.build();
	}
}
