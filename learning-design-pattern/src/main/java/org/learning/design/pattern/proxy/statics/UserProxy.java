package org.learning.design.pattern.proxy.statics;

import org.apache.log4j.Logger;

/**
 * @author summer.xia
 */
public class UserProxy implements IUser {
	private Logger logger = Logger.getLogger(UserProxy.class);
	private IUser user;

	public UserProxy(IUser user) {
		this.user = user;
	}

	@Override
	public void sayHello(String name) {
		logger.info("doing somthing before real thing which want to do");
		user.sayHello(name);
		logger.info("doing somthing after real thing which want to do");
	}

}
