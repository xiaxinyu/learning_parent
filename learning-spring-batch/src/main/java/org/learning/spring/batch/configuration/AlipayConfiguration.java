package org.learning.spring.batch.configuration;

import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.learning.spring.batch.listener.AlipayItemProcessListener;
import org.learning.spring.batch.listener.AlipayItemReaderListener;
import org.learning.spring.batch.listener.CSVJobEexecutionListener;
import org.learning.spring.batch.policy.retry.CSVRetryPolicy;
import org.learning.spring.batch.policy.skip.CSVSkipPolicy;
import org.learning.spring.batch.processor.AlipayProcessor;
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
public class AlipayConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ItemStreamReader<AlipayCSVBean> alipayCSVReader;
	
	@Autowired
	private ItemStreamWriter<AlipayCSVBean> alipayCSVWriter;

	@Bean
	public Step alipayCSVStep() {
		return stepBuilderFactory.get("alipayCSVStep")
				.<AlipayCSVBean, AlipayCSVBean>chunk(10)
				.listener(new AlipayItemReaderListener())
				.listener(new AlipayItemProcessListener())
				.reader(alipayCSVReader)
				.processor(new AlipayProcessor())
				.writer(alipayCSVWriter)
				.faultTolerant()
				.skipPolicy(new CSVSkipPolicy())
				.retryPolicy(new CSVRetryPolicy())
				.listener(new CSVJobEexecutionListener("Alipay"))
				.build();
	}

	@Bean
	public Job importAlipayCSVJob(Step alipayCSVStep) {
		return jobBuilderFactory
				.get("importAlipayCSVJob")
				.flow(alipayCSVStep)
				.end()
				.build();
	}
}
