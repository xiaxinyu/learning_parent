package org.learning.design.pattern.flyweight;

import org.junit.Assert;
import org.junit.Test;

public class FlyweightTest {
	@Test
	public void testFlyweight() {
		Order o1 = new Order(1);
		o1.setReceiveName("summer");

		Order o2 = new Order(1);
		o2.setReceiveName("winner");

		Assert.assertEquals(o1.getBook(), o2.getBook());
		Assert.assertNotEquals(o1, o2);
		Assert.assertNotEquals(o1.getReceiveName(), o2.getReceiveName());
		Assert.assertEquals(o1.getBook().getName(), o2.getBook().getName());
	}
}
