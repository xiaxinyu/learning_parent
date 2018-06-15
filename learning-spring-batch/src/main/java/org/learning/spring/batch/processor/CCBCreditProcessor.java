package org.learning.spring.batch.processor;

import org.learning.spring.batch.bean.CCBCreditCSVBean;
import org.learning.spring.batch.bean.DataLineBean;
import org.springframework.batch.item.ItemProcessor;

public class CCBCreditProcessor implements ItemProcessor<CCBCreditCSVBean, DataLineBean> {

	@Override
	public DataLineBean process(CCBCreditCSVBean orginalBean) throws Exception {
		return new DataLineBean(orginalBean.getCardNumberSuffix(), orginalBean.getTransactionDescription());
	}
}
