package org.learning.proxy.dynamic.jdk;

import org.learning.proxy.dynamic.utils.JDKProxyGeneratorUtils;
import org.learning.proxy.statics.IUser;
import org.learning.proxy.statics.UserImpl;

public class Test {
	public static void main(String[] args) {
		UserImpl userImpl = new UserImpl();
		IUser userProxy = (IUser)JDKProxyFactory.newProxy(userImpl);
		//SerializeUtils.write(, userProxy);
		JDKProxyGeneratorUtils.writeProxyClassToHardDisk("c:\\userImpl.class", userImpl);
	}
}
