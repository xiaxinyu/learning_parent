package org.learning.spring.batch.writer;

import org.learning.spring.batch.aggregator.AlipayLineAggregator;
import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class AlipayWriter {
	@Bean
	public ItemStreamWriter<AlipayCSVBean> alipayCSVWriter() {
		return new FlatFileItemWriterBuilder<AlipayCSVBean>()
				.lineSeparator("\n")
				.lineAggregator(new AlipayLineAggregator())
				.resource(new FileSystemResource("alipay-final.txt"))
				.name("transactionNumber,vendorOrderNumber,transactionTime,payTime,recentlyUpdateTime,transactionSource,type,transactionPart,goodsName,payMoney,outComeOrInCome,transactionStatus,serviceFee,refundMoney,comment,cashStatus")
				.build();
	}
}
