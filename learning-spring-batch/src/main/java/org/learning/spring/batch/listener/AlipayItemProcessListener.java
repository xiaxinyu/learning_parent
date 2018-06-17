package org.learning.spring.batch.listener;

import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

public class AlipayItemProcessListener implements ItemProcessListener<AlipayCSVBean, AlipayCSVBean> {
	private Logger logger = LoggerFactory.getLogger(AlipayItemProcessListener.class);

	@Override
	public void beforeProcess(AlipayCSVBean item) {
	}

	@Override
	public void afterProcess(AlipayCSVBean item, AlipayCSVBean result) {
	}

	@Override
	public void onProcessError(AlipayCSVBean item, Exception e) {
		logger.info(e.getMessage());
	}
}
