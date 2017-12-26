package com.learning.design.pattern.template;

public class WinnerShopping extends AbstractShopping{

	@Override
	public void view() {
		logger.info("View from phone");
	}

	@Override
	public void createBill() {
		logger.info("Put food in Shopping Cart");
	}

	@Override
	public void send() {
		logger.info("Sent package by SF");
	}

}
