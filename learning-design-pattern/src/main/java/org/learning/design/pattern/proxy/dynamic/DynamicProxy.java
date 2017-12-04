package org.learning.design.pattern.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author summer.xia
 */
public class DynamicProxy {

	public static Object newProxy(Object targetObject) {
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),
				new ProxyHandler(targetObject));
	}

}
