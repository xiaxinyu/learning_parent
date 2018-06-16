package org.learning.spring.batch.reader;

import org.learning.spring.batch.bean.ccb.CCBCreditCSVBean;
import org.learning.spring.batch.line.tokennizer.CCBCreditLineTokennizer;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class CCBCreditReader {
	@Bean
	public ItemStreamReader<CCBCreditCSVBean> ccbCreditCSVReader() {
		FlatFileItemReader<CCBCreditCSVBean> reader = new FlatFileItemReader<CCBCreditCSVBean>();
		reader.setResource(new ClassPathResource("中国建设银行信用卡账单（2018年06月）.txt"));
		reader.setLineMapper(new DefaultLineMapper<CCBCreditCSVBean>() {
			{
				setLineTokenizer(new CCBCreditLineTokennizer() {
					{
						setNames(new String[] { "transactionDate", "bookDate", "cardNumberSuffix", "transactionAmount",
								"settlementAmount", "transactionDescription" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<CCBCreditCSVBean>() {
					{
						setTargetType(CCBCreditCSVBean.class);
					}
				});
			}
		});
		reader.setLinesToSkip(5);
		return reader;
	}
}
