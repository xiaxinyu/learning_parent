package org.learning.design.pattern.proxy.statics;

import org.apache.log4j.Logger;

/**
 * @author summer.xiasz
 */
public class SummerUserImpl implements IUser {
	private Logger logger = Logger.getLogger(SummerUserImpl.class);

	@Override
	public void sayHello(String name) {
		logger.info("Hello," + name);
	}
}
