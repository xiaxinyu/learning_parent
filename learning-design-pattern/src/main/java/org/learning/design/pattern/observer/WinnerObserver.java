package org.learning.design.pattern.observer;

import org.apache.log4j.Logger;

public class WinnerObserver implements Observer {
	private Logger logger = Logger.getLogger(WinnerObserver.class);

	@Override
	public void update(String oldStatus, String newStatus) {
		logger.info("change from " + oldStatus + " to " + newStatus + " in " + WinnerObserver.class.getName());
	}
}