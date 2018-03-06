package org.learning.thread.concurrent.blockqueue;

public enum Product {
	CHOCOLATE(4), BANANA(3), APPLE(2), PEACH(1);
	private Integer price;

	Product(Integer price) {
		this.price = price;
	}

	public Integer price() {
		return price;
	}
}