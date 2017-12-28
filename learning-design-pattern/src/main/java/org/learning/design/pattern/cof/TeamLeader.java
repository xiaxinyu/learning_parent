package org.learning.design.pattern.cof;

public class TeamLeader  extends Auditing{
	public TeamLeader(Auditing auditing) {
		super(auditing);
	}

	@Override
	public void approve(double expense) {
		logger.info("Teamleader hasn't privilege to approve.");
		this.auditing.approve(expense);
	}
}
