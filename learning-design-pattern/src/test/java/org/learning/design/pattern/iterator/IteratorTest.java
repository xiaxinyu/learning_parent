package org.learning.design.pattern.iterator;

import org.apache.log4j.Logger;
import org.junit.Test;

public class IteratorTest {
	private Logger logger = Logger.getLogger(IteratorTest.class);

	@Test
	public void testIterator() {
		Container c = new ContainerImpl();
		c.add(1);
		c.add(2);

		Iterator i = c.getIterator();
		while (i.hasNext()) {
			logger.info(i.getNext());
		}
	}
}
