package org.learning.design.pattern.cof;

public class Manager extends Auditing {
	public Manager(Auditing auditing) {
		super(auditing);
	}

	@Override
	public void approve(double expense) {
		logger.info("Manager approves the expense.");
	}
}
