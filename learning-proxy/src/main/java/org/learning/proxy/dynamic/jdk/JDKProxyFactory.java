package org.learning.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

/**
 * @author summer.xia
 */
public class JDKProxyFactory {
	public static Object newProxy(Object targetObject) {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				targetObject.getClass().getInterfaces(), new ProxyHandler(targetObject));
	}
}
