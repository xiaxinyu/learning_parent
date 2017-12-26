package com.learning.design.pattern.strategy;

public class GoldMemberPrice implements MemberPrice {

	@Override
	public double calcPrice(double price) {
		logger.info("Gold members enjoy a 10% discount.");
		return price * 0.9;
	}

}
