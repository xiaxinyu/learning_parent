package org.learning.design.pattern.decoration;

import org.apache.log4j.Logger;

/**
 * @author summer.xiasz
 */
public class Programer implements Project {
	private Logger logger = Logger.getLogger(Programer.class);

	@Override
	public void coding() {
		logger.info("Programer work hard to code.");
	}
}
