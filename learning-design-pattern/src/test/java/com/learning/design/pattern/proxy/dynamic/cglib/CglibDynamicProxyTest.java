package com.learning.design.pattern.proxy.dynamic.cglib;

import org.junit.Test;
import org.learning.design.pattern.proxy.dynamic.cglib.CglibDynamicProxy;
import org.learning.design.pattern.proxy.statics.IUser;
import org.learning.design.pattern.proxy.statics.SummerUserImpl;

public class CglibDynamicProxyTest {
	@Test
	public void testSayHello(){
		CglibDynamicProxy proxy = new CglibDynamicProxy();
		IUser user = (IUser)proxy.getInstance(new SummerUserImpl());
		user.sayHello("Cglib Dynamic Proxy");
	}
}
