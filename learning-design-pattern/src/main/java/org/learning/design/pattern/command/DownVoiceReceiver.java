package org.learning.design.pattern.command;

import org.apache.log4j.Logger;

public class DownVoiceReceiver implements Receiver {
	private Logger logger = Logger.getLogger(DownVoiceReceiver.class);
	
	@Override
	public void execute() {
		logger.info("execute up voice command");
	}

}
