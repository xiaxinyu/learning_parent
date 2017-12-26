package com.learning.design.pattern.strategy;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StrategyTest {
	private Logger logger = Logger.getLogger(StrategyTest.class);

	@Test
	public void testStrategy() {
		Price p = new Price(new GoldMemberPrice());
		double price = p.calcPrice(100);
		logger.info("final price is " + price);
	}
}
