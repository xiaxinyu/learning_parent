package org.learning.proxy.statics;

import java.io.Serializable;

/**
 * @author summer.xia
 */
public class UserImpl implements IUser, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void sayHello(String name) {
		System.out.println("Hello," + name);
	}

	@Override
	public void sayWorld(String name) {
		System.out.println("World," + name);
	}
}