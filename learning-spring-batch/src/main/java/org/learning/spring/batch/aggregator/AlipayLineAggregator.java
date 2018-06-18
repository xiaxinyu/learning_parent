package org.learning.spring.batch.aggregator;

import org.learning.spring.batch.bean.alipay.AlipayCSVBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.transform.ExtractorLineAggregator;

public class AlipayLineAggregator extends ExtractorLineAggregator<AlipayCSVBean> {
	private Logger logger = LoggerFactory.getLogger(AlipayLineAggregator.class);

	private String delimiter = ",";

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	@Override
	protected String doAggregate(Object[] fields) {
		if (fields != null && fields.length > 0) {
			StringBuilder aggregator = new StringBuilder();
			AlipayCSVBean bean = (AlipayCSVBean) fields[0];
			aggregator.append(bean.getTransactionNumber() + delimiter);
			aggregator.append(bean.getVendorOrderNumber() + delimiter);
			aggregator.append(bean.getTransactionTime() + delimiter);
			aggregator.append(bean.getPayTime() + delimiter);
			aggregator.append(bean.getRecentlyUpdateTime() + delimiter);
			aggregator.append(bean.getTransactionSource() + delimiter);
			aggregator.append(bean.getType() + delimiter);
			aggregator.append(bean.getTransactionPart() + delimiter);
			aggregator.append(bean.getGoodsName() + delimiter);
			aggregator.append(bean.getPayMoney() + delimiter);
			aggregator.append(bean.getTransactionStatus() + delimiter);
			aggregator.append(bean.getServiceFee() + delimiter);
			aggregator.append(bean.getRefundMoney() + delimiter);
			aggregator.append(bean.getComment() + delimiter);
			aggregator.append(bean.getCashStatus() + delimiter);
			aggregator.append(bean.getVendorOrderNumber() + delimiter);
			aggregator.append(bean.getVendorOrderNumber());
			return aggregator.toString();
		}
		return null;
	}
}