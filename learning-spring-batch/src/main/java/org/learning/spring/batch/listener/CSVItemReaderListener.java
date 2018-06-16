package org.learning.spring.batch.listener;

import org.learning.spring.batch.bean.ccb.CCBCreditCSVBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

public class CSVItemReaderListener implements ItemReadListener<CCBCreditCSVBean> {
	private Logger logger = LoggerFactory.getLogger(CSVItemReaderListener.class);

	private String type;

	public CSVItemReaderListener(String type) {
		this.type = type;
	}

	@Override
	public void beforeRead() {

	}

	@Override
	public void afterRead(CCBCreditCSVBean item) {

	}

	@Override
	public void onReadError(Exception ex) {
		logger.info(type + " :" + ex.getMessage());
	}
}
