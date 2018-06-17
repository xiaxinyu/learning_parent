package org.learning.spring.batch.listener;

import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

public class AlipayItemReaderListener implements ItemReadListener<AlipayCSVBean> {
	private Logger logger = LoggerFactory.getLogger(AlipayItemReaderListener.class);

	@Override
	public void beforeRead() {
	}

	@Override
	public void afterRead(AlipayCSVBean item) {
	}

	@Override
	public void onReadError(Exception ex) {
		logger.info(ex.getMessage());
	}
}
