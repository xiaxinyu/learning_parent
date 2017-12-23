package org.learning.design.pattern.command;

import org.apache.log4j.Logger;

public class PowerReceiver implements Receiver {
	private Logger logger = Logger.getLogger(PowerReceiver.class);
	
	@Override
	public void execute() {
		logger.info("execute power command");
	}

}
