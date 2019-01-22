package org.learning.jvm;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 设置方法区最大、最小空间：-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m<br>
 * 运行时通过cglib不断创建JavaMethodAreaOOM的子类，方法区中类信息越来越多，最终没有可以为新的类分配的内存导致内存溢出
 */
public class MetaspaceOOMError {

	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(TestCase.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				@Override
				public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
					return arg3.invokeSuper(arg0, arg2);
				}
			});
			enhancer.create();
		}
	}
}

class TestCase {

}