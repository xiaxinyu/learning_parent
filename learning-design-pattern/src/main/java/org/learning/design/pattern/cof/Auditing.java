package org.learning.design.pattern.cof;

import org.apache.log4j.Logger;

public abstract class Auditing {
	protected Logger logger = Logger.getLogger(Auditing.class);
	protected Auditing auditing;

	public Auditing(Auditing auditing) {
		this.auditing = auditing;
	}

	public abstract void approve(double expense);
}
