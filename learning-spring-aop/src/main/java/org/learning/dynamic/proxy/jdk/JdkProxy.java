package org.learning.dynamic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
	private Object targetObject;

	public Object newProxy(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		checkPopedom();
		Object ret = null;
		ret = method.invoke(targetObject, args);
		return ret;
	}

	private void checkPopedom() {
		System.out.println(".:检查权限  checkPopedom()!");
	}
}
