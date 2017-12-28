package com.learning.design.pattern.flyweight;

import java.util.Date;

public class Order {
	private int orderId;
	private Date date;
	private String receiveName;
	private String receivePhone;
	private IBook book;
	
	public Order(int bookId) {
		book = BookFactory.getInstance().createBook(bookId);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}

	public IBook getBook() {
		return book;
	}
}
