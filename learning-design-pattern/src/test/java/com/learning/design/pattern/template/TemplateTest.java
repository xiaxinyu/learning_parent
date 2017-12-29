package com.learning.design.pattern.template;

import org.junit.Test;

public class TemplateTest {
	@Test
	public void testTemplate() {
		AbstractShopping shopping1 = new SummerShopping();
		AbstractShopping shopping2 = new WinnerShopping();
		shopping1.buy();
		shopping2.buy();
	}
}
