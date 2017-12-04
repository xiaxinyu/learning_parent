package com.learning.design.pattern.proxy.statics;

import org.junit.Test;
import org.learning.design.pattern.proxy.statics.IUser;
import org.learning.design.pattern.proxy.statics.SummerUserImpl;
import org.learning.design.pattern.proxy.statics.UserProxy;

/**
 * @author summer.xia
 */
public class StaticProxyTest {
	@Test
	public void testSayHello() {
		IUser user = new SummerUserImpl();
		UserProxy proxy = new UserProxy(user);
		proxy.sayHello("Proxy");
	}
}
