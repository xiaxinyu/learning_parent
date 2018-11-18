package org.learning.dynamic.proxy.cglib;

import org.learning.dynamic.proxy.cglib.CglibProxy;
import org.learning.spring.aop.proxy.UserManager;
import org.learning.spring.aop.proxy.UserManagerImpl;

public class CglibProxyTest {
	public static void main(String[] args) {
		UserManager userManagerCglib = (UserManager) new CglibProxy().createProxyObject(new UserManagerImpl());
		System.out.println("-----------CGLibProxy-------------");
		userManagerCglib.addUser("summer", "winner");
	}
}
