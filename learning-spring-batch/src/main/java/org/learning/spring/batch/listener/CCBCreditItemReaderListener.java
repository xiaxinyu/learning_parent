package org.learning.spring.batch.listener;

import org.learning.spring.batch.bean.CCBCreditCSVBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

public class CCBCreditItemReaderListener implements ItemReadListener<CCBCreditCSVBean> {
	private Logger logger = LoggerFactory.getLogger(CCBCreditItemReaderListener.class);

	@Override
	public void beforeRead() {
		
	}

	@Override
	public void afterRead(CCBCreditCSVBean item) {
		
	}

	@Override
	public void onReadError(Exception ex) {
		logger.info(ex.getMessage());
	}
}
