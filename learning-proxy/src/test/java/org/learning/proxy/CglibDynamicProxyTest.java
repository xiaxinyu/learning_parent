package org.learning.proxy;

import org.junit.Test;
import org.learning.proxy.dynamic.cglib.CglibDynamicProxy;
import org.learning.proxy.statics.CGLibUser;

public class CglibDynamicProxyTest {
	@Test
	public void testSayHello(){
		CglibDynamicProxy proxy = new CglibDynamicProxy();
		CGLibUser user = (CGLibUser)proxy.getInstance(new CGLibUser());
		user.sayHello("Cglib Dynamic Proxy");
		user.sayWorld("Cglib Dynamic Proxy");
	}
}
