package org.learning.spring.batch.reader;

import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.learning.spring.batch.line.tokennizer.AlipayLineTokennizer;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class AlipayReader {
	@Bean
	public ItemStreamReader<AlipayCSVBean> alipayCSVReader() {
		FlatFileItemReader<AlipayCSVBean> reader = new FlatFileItemReader<AlipayCSVBean>();
		reader.setResource(new ClassPathResource("alipay_record_20180616_1612_1.csv"));
		reader.setLineMapper(new DefaultLineMapper<AlipayCSVBean>() {
			{
				setLineTokenizer(new AlipayLineTokennizer() {
					{
						setNames(new String[] { "transactionNumber", "vendorOrderNumber", "transactionTime", "payTime",
								"recentlyUpdateTime", "transactionSource", "type", "transactionPart", "goodsName",
								"payMoney", "outComeOrInCome", "transactionStatus", "serviceFee", "refundMoney",
								"comment", "cashStatus" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<AlipayCSVBean>() {
					{
						setTargetType(AlipayCSVBean.class);
					}
				});
			}
		});
		return reader;
	}
}
