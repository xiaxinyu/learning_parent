package org.learning.design.pattern.factory;

import org.junit.Assert;
import org.junit.Test;
import org.learning.design.pattern.factory.bean.Phone;

public class FactoryTest {
	@Test
	public void testFactory1() {
		Phone phone = PhoneFactory.createPhone();
		Assert.assertFalse(new Phone("Mi-001", "Mi").equals(phone));
	}
}