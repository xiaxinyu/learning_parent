package org.learning.spring.batch.listener;

import java.util.List;

import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

public class AlipayItemWriterListener implements ItemWriteListener<AlipayCSVBean> {
	private Logger logger = LoggerFactory.getLogger(AlipayItemWriterListener.class);

	@Override
	public void beforeWrite(List<? extends AlipayCSVBean> items) {
	}

	@Override
	public void afterWrite(List<? extends AlipayCSVBean> items) {
	}

	@Override
	public void onWriteError(Exception exception, List<? extends AlipayCSVBean> items) {
		logger.info(exception.getMessage());
	}
}
