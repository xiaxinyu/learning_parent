package org.learning.design.pattern.bridge;

public class CircularBox extends Box {

	public CircularBox(Goods goods) {
		super(goods);
	}

	@Override
	public void showExterior() {
		round();
		super.showExterior();
	}

	public void round() {
		logger.info("Generate circular box");
	}
}
