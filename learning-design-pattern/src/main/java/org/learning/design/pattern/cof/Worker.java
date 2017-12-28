package org.learning.design.pattern.cof;

public class Worker extends Auditing {
	public Worker(Auditing auditing) {
		super(auditing);
	}

	@Override
	public void approve(double expense) {
		logger.info("Worker submit an expense, expense is " + expense);
		this.auditing.approve(expense);
	}
}
