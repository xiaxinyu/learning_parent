package org.learning.spring.batch.listener;

import org.learning.spring.batch.bean.CCBCreditCSVBean;
import org.learning.spring.batch.bean.DataLineBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

public class CCBCreditSkipListener implements SkipListener<CCBCreditCSVBean, DataLineBean> {
	private Logger logger =LoggerFactory.getLogger(CCBCreditSkipListener.class);
	@Override
	public void onSkipInRead(Throwable t) {
		logger.info(t.getMessage());
	}

	@Override
	public void onSkipInWrite(DataLineBean item, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSkipInProcess(CCBCreditCSVBean item, Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
