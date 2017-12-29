package org.learning.design.pattern.strategy;

import org.apache.log4j.Logger;

public interface MemberPrice {
	public Logger logger = Logger.getLogger(MemberPrice.class);
	public double calcPrice(double price);
}
