package org.learning.design.pattern.strategy;

public class BronzeMemberPrice implements MemberPrice {

	@Override
	public double calcPrice(double price) {
		logger.info("Bronze members enjoy a 2% discount.");
		return price * 0.98;
	}

}
