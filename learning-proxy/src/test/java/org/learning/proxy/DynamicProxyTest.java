package org.learning.proxy;

import org.junit.Test;
import org.learning.proxy.dynamic.jdk.JDKDynamicProxy;
import org.learning.proxy.statics.IUser;
import org.learning.proxy.statics.UserImpl;

public class DynamicProxyTest {
	@Test
	public void testSayHello(){
		IUser userProxy = (IUser)JDKDynamicProxy.newProxy(new UserImpl());
		userProxy.sayHello("Dynamic Proxy");
		userProxy.sayWorld("Dynamic Proxy");
	}
}
