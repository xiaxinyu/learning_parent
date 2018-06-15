package org.learning.spring.batch.reader;

import org.learning.spring.batch.bean.CCBCreditCSVBean;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class CCBCreditReader {
	@Bean
	public ItemStreamReader<CCBCreditCSVBean> ccbCreditCSVReader() {
		return new FlatFileItemReaderBuilder<CCBCreditCSVBean>()
				.name("personItemReader")
				.resource(new ClassPathResource("中国建设银行信用卡账单（2018年06月）.txt"))
				.delimited()
				.names(new String[] { "transactionDate", "bookDate", "cardNumberSuffix", "transactionAmount",
						"settlementAmount", "transactionDescription" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<CCBCreditCSVBean>() {
					{
						setTargetType(CCBCreditCSVBean.class);
					}
				}).build();
	}
}
