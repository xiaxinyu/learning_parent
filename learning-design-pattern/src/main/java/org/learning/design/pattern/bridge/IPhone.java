package org.learning.design.pattern.bridge;

public class IPhone implements Goods {

	@Override
	public void showIntention() {
		logger.info("Stand for friendship.");
	}

}
