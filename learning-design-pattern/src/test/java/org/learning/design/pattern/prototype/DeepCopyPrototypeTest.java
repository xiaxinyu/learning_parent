package org.learning.design.pattern.prototype;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.learning.design.pattern.prototype.deepcopy.NewPrototype;
import org.learning.design.pattern.prototype.lightcopy.Prototype;

public class DeepCopyPrototypeTest {
	private Logger logger = Logger.getLogger(DeepCopyPrototypeTest.class);

	@Test
	public void testNewPrototype() {
		Prototype pro = new Prototype();
		pro.setName("original object");
		NewPrototype newObj = new NewPrototype();
		newObj.setId("test1");
		newObj.setPrototype(pro);

		NewPrototype copyObj = (NewPrototype) newObj.clone();
		copyObj.setId("testCopy");
		copyObj.getPrototype().setName("changed object");

		logger.info("original object id:" + newObj.getId());
		logger.info("original object name:" + newObj.getPrototype().getName());

		logger.info("cloned object id:" + copyObj.getId());
		logger.info("cloned object name:" + copyObj.getPrototype().getName());
	}
}
