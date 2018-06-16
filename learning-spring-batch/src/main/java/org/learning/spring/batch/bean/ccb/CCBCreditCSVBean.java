package org.learning.spring.batch.bean.ccb;

public class CCBCreditCSVBean {
	private String transactionDate;
	private String bookDate;
	private String cardNumberSuffix;
	private String transactionAmount;
	private String settlementAmount;
	private String transactionDescription;

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getCardNumberSuffix() {
		return cardNumberSuffix;
	}

	public void setCardNumberSuffix(String cardNumberSuffix) {
		this.cardNumberSuffix = cardNumberSuffix;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(String settlementAmount) {
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
		return "CCBCreditCSVBean [transactionDate=" + transactionDate + ", bookDate=" + bookDate + ", cardNumberSuffix="
				+ cardNumberSuffix + ", transactionAmount=" + transactionAmount + ", settlementAmount="
				+ settlementAmount + ", transactionDescription=" + transactionDescription + "]";
	}
}
