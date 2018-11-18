package org.learning.dynamic.proxy.jdk;

import org.learning.spring.aop.proxy.UserManager;
import org.learning.spring.aop.proxy.UserManagerImpl;

public class JdkProxyTest {
	public static void main(String[] args) {
		System.out.println("-----------JDKProxy-------------");
		UserManager userManagerProxy = (UserManager) new JdkProxy().newProxy(new UserManagerImpl());
		userManagerProxy.addUser("autumn", "autumn123");
	}
}
