package org.learning.proxy.statics;

/**
 * @author summer.xia
 */
public class UserImpl implements IUser {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello," + name);
	}

	@Override
	public void sayWorld(String name) {
		System.out.println("World," + name);
	}
}