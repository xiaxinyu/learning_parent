package org.learning.spring.batch.bean;

import java.util.Date;

public class DataLineBean {
	private Date transactionDate;
	private Date bookDate;
	private String cardNumber;
	private String currency;
	private Double transactionAmount;
	private Double settlementAmount;
	private String transactionDescription;

	public DataLineBean(String cardNumber, String transactionDescription) {
		this.cardNumber = cardNumber;
		this.transactionDescription = transactionDescription;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Double getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(Double settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	@Override
	public String toString() {
		return "DataLineBean [transactionDate=" + transactionDate + ", bookDate=" + bookDate + ", cardNumber="
				+ cardNumber + ", currency=" + currency + ", transactionAmount=" + transactionAmount
				+ ", settlementAmount=" + settlementAmount + ", transactionDescription=" + transactionDescription + "]";
	}
}
