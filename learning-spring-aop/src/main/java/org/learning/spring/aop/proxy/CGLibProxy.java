package org.learning.spring.aop.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor {
	private Object targetObject;

	public Object createProxyObject(Object targetObject) {
		this.targetObject = targetObject;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetObject.getClass());
		enhancer.setCallback(this);
		Object proxyObject = enhancer.create();
		return proxyObject;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object object = null;
		if ("addUser".equals(method.getName())) {
			checkPopedom();
		}
		object = method.invoke(this.targetObject, args);
		return object;
	}

	private void checkPopedom() {
		System.out.println(".:检查权限  checkPopedom()!");
	}
}
