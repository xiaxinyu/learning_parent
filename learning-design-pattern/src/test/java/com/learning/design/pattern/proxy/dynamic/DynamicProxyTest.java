package com.learning.design.pattern.proxy.dynamic;

import org.junit.Test;
import org.learning.design.pattern.proxy.dynamic.DynamicProxy;
import org.learning.design.pattern.proxy.statics.IUser;
import org.learning.design.pattern.proxy.statics.SummerUserImpl;

public class DynamicProxyTest {
	@Test
	public void testSayHello(){
		IUser userProxy = (IUser)DynamicProxy.newProxy(new SummerUserImpl());
		userProxy.sayHello("Dynamic Proxy");
	}
}
