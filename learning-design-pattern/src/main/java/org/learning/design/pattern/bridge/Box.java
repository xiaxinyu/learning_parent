package org.learning.design.pattern.bridge;

import org.apache.log4j.Logger;

public abstract class Box {
	protected Logger logger = Logger.getLogger(Box.class);
	private Goods goods;

	public Box(Goods goods) {
		this.goods = goods;
	}

	public void showExterior() {
		this.goods.showIntention();
	}
}
