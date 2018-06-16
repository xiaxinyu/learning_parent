package org.learning.spring.batch.writer;

import org.learning.spring.batch.bean.ccb.CCBCreditDataLineBean;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class CCBCreditWriter {
	@Bean
	public ItemStreamWriter<CCBCreditDataLineBean> ccbCreditWriter() {
        return new FlatFileItemWriterBuilder<CCBCreditDataLineBean>()
        		.lineSeparator("\n")
        		.lineAggregator(new DelimitedLineAggregator<>())
        		.resource(new FileSystemResource("ccb-final.txt"))
        		.name("cardNumber,transactionDescription").build();
    }
}
