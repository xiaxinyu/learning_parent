package org.rpc.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.rpc.api.bean.RPCProtocol;
import org.rpc.api.util.SerializeUtils;

public class ProxyFactory {
	
	private static InvocationHandler handler = new InvocationHandler() {
		// 1.将本地的接口调用转换成JDK的动态代理，在动态代理中实现接口的远程调用
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			RPCProtocol netModel = new RPCProtocol();
			
			Class<?>[] classes = proxy.getClass().getInterfaces();
			String className = classes[0].getName();

			netModel.setClassName(className);
			netModel.setArgs(args);
			netModel.setMethod(method.getName());
			System.out.println("class"+className);
			System.out.println("method:"+method.getName());
			String [] types = null; 
			if(args!=null) {
				types = new String [args.length];
				for (int i = 0; i < types.length; i++) {
					types[i] = args[i].getClass().getName();
				}
			}
			netModel.setTypes(types);
			
			byte[] byteArray = SerializeUtils.serialize(netModel);
			Object send = RPCClient.send(byteArray);
			return send;
		}
	};

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), 
				new Class[]{clazz}, handler );
	}
}
