package org.learning.design.pattern.factory.service.impl;

import org.learning.design.pattern.factory.bean.Phone;
import org.learning.design.pattern.factory.service.IPhoneService;

public class MiServiceImpl implements IPhoneService{

	public Phone createPhone() {
		return new Phone("Mi-001","Mi");
	}

}