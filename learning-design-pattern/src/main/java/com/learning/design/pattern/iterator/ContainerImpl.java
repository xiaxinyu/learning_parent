package com.learning.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class ContainerImpl implements Container {
	@SuppressWarnings("rawtypes")
	private List list = new ArrayList();

	@SuppressWarnings("unchecked")
	@Override
	public void add(Object obj) {
		this.list.add(obj);
	}

	@Override
	public void remove(Object obj) {
		this.list.remove(obj);
	}

	@Override
	public Iterator getIterator() {
		return new IteratorImpl(this);
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public Object get(int index) {
		return this.list.get(index);
	}

}
