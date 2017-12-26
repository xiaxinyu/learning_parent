package com.learning.design.pattern.bridge;

import org.junit.Test;
import org.learning.design.pattern.bridge.Box;
import org.learning.design.pattern.bridge.CircularBox;
import org.learning.design.pattern.bridge.Goods;
import org.learning.design.pattern.bridge.IPhone;

public class BridgeTest {
	@Test
	public void testBridge() {
		Goods goods = new IPhone();
		Box box = new CircularBox(goods);
		box.showExterior();
	}
}
