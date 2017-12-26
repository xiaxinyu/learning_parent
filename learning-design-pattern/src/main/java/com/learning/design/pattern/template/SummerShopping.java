package com.learning.design.pattern.template;

public class SummerShopping extends AbstractShopping{

	@Override
	public void view() {
		logger.info("View from Computer");
	}

	@Override
	public void createBill() {
		logger.info("Put Cameron in Shopping Cart");
	}

	@Override
	public void send() {
		logger.info("Sent package by JD");
	}

}
