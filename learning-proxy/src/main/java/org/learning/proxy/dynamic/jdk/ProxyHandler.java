package org.learning.proxy.dynamic.jdk;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler, Serializable {
	private static final long serialVersionUID = 1L;
	private Object targetObject;

	public ProxyHandler(Object targetObject) {
		this.targetObject = targetObject;
	}

	public void before(String param) {
		System.out.println("doing somthing before real thing which want to do, param=" + param);
	}

	public void after(String param) {
		System.out.println("doing somthing after real thing which want to do");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before((String) args[0]);
		Object object = method.invoke(targetObject, args);
		after((String) args[0]);
		return object;
	}
}