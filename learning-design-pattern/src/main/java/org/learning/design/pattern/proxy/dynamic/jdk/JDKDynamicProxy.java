package org.learning.design.pattern.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

/**
 * @author summer.xia
 */
public class JDKDynamicProxy {

	public static Object newProxy(Object targetObject) {
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),
				new ProxyHandler(targetObject));
	}

}
