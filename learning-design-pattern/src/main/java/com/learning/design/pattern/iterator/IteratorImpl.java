package com.learning.design.pattern.iterator;

public class IteratorImpl implements Iterator {
	private Container container;
	private int count = -1;

	public IteratorImpl(Container container) {
		this.container = container;
	}

	@Override
	public boolean hasNext() {
		boolean bool = false;
		this.count ++;
		bool = this.count < this.container.size();
		return bool;
	}

	@Override
	public Object getNext() {
		return this.container.get(count);
	}
}
