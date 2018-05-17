package org.learning.spring.aop.proxy;

public class Client {
	public static void main(String[] args) {
		UserManager userManagerCglib = (UserManager) new CGLibProxy().createProxyObject(new UserManagerImpl());
		System.out.println("-----------CGLibProxy-------------");
		userManagerCglib.addUser("summer", "winner");
		System.out.println("-----------JDKProxy-------------");
		UserManager userManagerProxy = (UserManager) new JDKProxy().newProxy(new UserManagerImpl());
		userManagerProxy.addUser("autumn", "autumn123");
	}
}
