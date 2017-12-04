package org.learning.design.pattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class ProxyHandler implements InvocationHandler {
	private Logger logger = Logger.getLogger(ProxyHandler.class);
	private Object targetObject;

	public ProxyHandler(Object targetObject) {
		this.targetObject = targetObject;
	}

	public void before(String param) {
		logger.info("doing somthing before real thing which want to do, param=" + param);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before((String) args[0]);
		return method.invoke(targetObject, args);
	}

}
