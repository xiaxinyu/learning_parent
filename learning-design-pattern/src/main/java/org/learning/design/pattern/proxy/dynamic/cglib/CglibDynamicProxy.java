package org.learning.design.pattern.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor {
	private Logger logger = Logger.getLogger(CglibDynamicProxy.class);
	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		logger.info("doing somthing before real thing which want to do");
		proxy.invokeSuper(obj, args);
		logger.info("doing somthing after real thing which want to do");
		return null;
	}

}
