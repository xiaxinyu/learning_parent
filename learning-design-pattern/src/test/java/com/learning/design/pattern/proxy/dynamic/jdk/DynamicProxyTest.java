package com.learning.design.pattern.proxy.dynamic.jdk;

import org.junit.Test;
import org.learning.design.pattern.proxy.dynamic.jdk.JDKDynamicProxy;
import org.learning.design.pattern.proxy.statics.IUser;
import org.learning.design.pattern.proxy.statics.SummerUserImpl;

public class DynamicProxyTest {
	@Test
	public void testSayHello(){
		IUser userProxy = (IUser)JDKDynamicProxy.newProxy(new SummerUserImpl());
		userProxy.sayHello("Dynamic Proxy");
	}
}
