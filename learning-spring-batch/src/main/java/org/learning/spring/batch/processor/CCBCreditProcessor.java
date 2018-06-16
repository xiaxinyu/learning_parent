package org.learning.spring.batch.processor;

import org.learning.spring.batch.bean.ccb.CCBCreditCSVBean;
import org.learning.spring.batch.bean.ccb.CCBCreditDataLineBean;
import org.springframework.batch.item.ItemProcessor;

public class CCBCreditProcessor implements ItemProcessor<CCBCreditCSVBean, CCBCreditDataLineBean> {

	@Override
	public CCBCreditDataLineBean process(CCBCreditCSVBean orginalBean) throws Exception {
		return new CCBCreditDataLineBean(orginalBean.getCardNumberSuffix(), orginalBean.getTransactionDescription());
	}
}
