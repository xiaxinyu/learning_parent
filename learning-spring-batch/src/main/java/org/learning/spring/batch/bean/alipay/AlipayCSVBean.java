package org.learning.spring.batch.bean.alipay;

public class AlipayCSVBean {
	private String transactionNumber;
	private String vendorOrderNumber;
	private String transactionTime;
	private String payTime;
	private String recentlyUpdateTime;
	private String transactionSource;
	private String type;
	private String transactionPart;
	private String goodsName;
	private String payMoney;
	private String outComeOrInCome;
	private String transactionStatus;
	private String serviceFee;
	private String refundMoney;
	private String comment;
	private String cashStatus;

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getVendorOrderNumber() {
		return vendorOrderNumber;
	}

	public void setVendorOrderNumber(String vendorOrderNumber) {
		this.vendorOrderNumber = vendorOrderNumber;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getRecentlyUpdateTime() {
		return recentlyUpdateTime;
	}

	public void setRecentlyUpdateTime(String recentlyUpdateTime) {
		this.recentlyUpdateTime = recentlyUpdateTime;
	}

	public String getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransactionPart() {
		return transactionPart;
	}

	public void setTransactionPart(String transactionPart) {
		this.transactionPart = transactionPart;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getOutComeOrInCome() {
		return outComeOrInCome;
	}

	public void setOutComeOrInCome(String outComeOrInCome) {
		this.outComeOrInCome = outComeOrInCome;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(String refundMoney) {
		this.refundMoney = refundMoney;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(String cashStatus) {
		this.cashStatus = cashStatus;
	}

	@Override
	public String toString() {
		return "AlipayCSVBean [transactionNumber=" + transactionNumber + ", vendorOrderNumber=" + vendorOrderNumber
				+ ", transactionTime=" + transactionTime + ", payTime=" + payTime + ", recentlyUpdateTime="
				+ recentlyUpdateTime + ", transactionSource=" + transactionSource + ", type=" + type
				+ ", transactionPart=" + transactionPart + ", goodsName=" + goodsName + ", payMoney=" + payMoney
				+ ", outComeOrInCome=" + outComeOrInCome + ", transactionStatus=" + transactionStatus + ", serviceFee="
				+ serviceFee + ", refundMoney=" + refundMoney + ", comment=" + comment + ", cashStatus=" + cashStatus
				+ "]";
	}
}
