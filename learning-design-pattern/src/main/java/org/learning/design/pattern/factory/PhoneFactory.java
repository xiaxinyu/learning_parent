package org.learning.design.pattern.factory;

import org.learning.design.pattern.factory.bean.Phone;
import org.learning.design.pattern.factory.service.IPhoneService;
import org.learning.design.pattern.util.PropertiesUtil;
import org.learning.design.pattern.util.ReflectUtil;

public class PhoneFactory {
	public static Phone createPhone() {
		String className = PropertiesUtil.getValue("phoneService");
		return ((IPhoneService) ReflectUtil.getObject(className)).createPhone();
	}
}
