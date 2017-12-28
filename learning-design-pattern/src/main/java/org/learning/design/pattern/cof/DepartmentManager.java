package org.learning.design.pattern.cof;

public class DepartmentManager  extends Auditing{
	public DepartmentManager(Auditing auditing) {
		super(auditing);
	}

	@Override
	public void approve(double expense) {
		if(expense <= 1000) {
			logger.info("Department manager approves the expense.");
		}else {
			logger.info("Department manager hasn't privilege to approve the expense that the account is over 1000 RMB.");
			this.auditing.approve(expense);
		}
	}
}
