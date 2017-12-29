package org.learning.design.pattern.template;

import org.apache.log4j.Logger;

public abstract class AbstractShopping {
	protected Logger logger = Logger.getLogger(AbstractShopping.class);

	public abstract void view();

	public abstract void createBill();

	public void payBill() {
		logger.info("Pay bill for goods!");
	}

	public abstract void send();

	public void buy() {
		view();
		createBill();
		payBill();
		send();
	}
}
