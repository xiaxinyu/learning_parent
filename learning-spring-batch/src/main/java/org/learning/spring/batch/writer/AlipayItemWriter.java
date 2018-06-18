package org.learning.spring.batch.writer;

import java.util.List;

import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.learning.spring.batch.exception.WriterEpxception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.adapter.ItemWriterAdapter;

public class AlipayItemWriter extends ItemWriterAdapter<AlipayCSVBean> {
	private Logger logger = LoggerFactory.getLogger(AlipayItemWriter.class);

	@Override
	public void write(List<? extends AlipayCSVBean> items) throws Exception {
		for (AlipayCSVBean alipayCSVBean : items) {
			if (alipayCSVBean.getTransactionNumber().equals("20180517356607617861")) {
				throw new WriterEpxception(AlipayItemWriter.class.getName(), alipayCSVBean.toString());
			}
			logger.info(alipayCSVBean.toString());
		}
	}
}
