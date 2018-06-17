package org.learning.spring.batch.processor;

import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.learning.spring.batch.exception.ProcessorEpxception;
import org.springframework.batch.item.ItemProcessor;

public class AlipayProcessor implements ItemProcessor<AlipayCSVBean, AlipayCSVBean> {
	@Override
	public AlipayCSVBean process(AlipayCSVBean orginalBean) throws Exception {
		AlipayCSVBean result = new AlipayCSVBean();
		result.setTransactionNumber(orginalBean.getTransactionNumber().trim());
		result.setVendorOrderNumber(orginalBean.getVendorOrderNumber().trim());
		result.setTransactionTime(orginalBean.getTransactionTime().trim());
		result.setPayTime(orginalBean.getPayTime().trim());
		result.setRecentlyUpdateTime(orginalBean.getRecentlyUpdateTime().trim());
		result.setTransactionSource(orginalBean.getTransactionSource().trim());
		result.setType(orginalBean.getType().trim());
		result.setTransactionPart(orginalBean.getTransactionPart().trim());
		result.setGoodsName(orginalBean.getGoodsName().trim());
		result.setPayMoney(orginalBean.getPayMoney().trim());
		result.setOutComeOrInCome(orginalBean.getOutComeOrInCome().trim());
		result.setTransactionStatus(orginalBean.getTransactionStatus().trim());
		result.setServiceFee(orginalBean.getServiceFee().trim());
		result.setRefundMoney(orginalBean.getRefundMoney().trim());
		result.setComment(orginalBean.getComment().trim());
		result.setCashStatus(orginalBean.getCashStatus().trim());
		if (result.getTransactionNumber().equals("20180608324979197861")) {
			throw new ProcessorEpxception(AlipayProcessor.class.getName(), result.toString());
		}
		return result;
	}
}
