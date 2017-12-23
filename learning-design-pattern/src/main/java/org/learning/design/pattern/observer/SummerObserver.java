package org.learning.design.pattern.observer;

import org.apache.log4j.Logger;

public class SummerObserver implements Observer {
	private Logger logger = Logger.getLogger(SummerObserver.class);

	@Override
	public void update(String oldStatus, String newStatus) {
		logger.info("change from " + oldStatus + " to " + newStatus + " in " + SummerObserver.class.getName());
	}
}